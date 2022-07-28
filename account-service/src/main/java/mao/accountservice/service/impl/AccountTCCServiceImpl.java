package mao.accountservice.service.impl;

import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import mao.accountservice.entity.AccountFreeze;
import mao.accountservice.mapper.AccountFreezeMapper;
import mao.accountservice.mapper.AccountMapper;
import mao.accountservice.service.AccountTCCService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.accountservice.service.impl
 * Class(类名): AccountTCCServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/28
 * Time(创建时间)： 13:27
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class AccountTCCServiceImpl implements AccountTCCService
{

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountFreezeMapper accountFreezeMapper;


    @Override
    @Transactional
    public void prepare(String userId, int money)
    {
        //try方法，资源的检测和预留

        //获得事务的xid
        String xid = RootContext.getXID();
        //打印日志
        log.debug("开始执行prepare方法，用户id为" + userId + "，事务id为" + xid);

        //查询冻结记录，解决业务悬挂问题
        log.debug("开始查询冻结记录");
        AccountFreeze accountFreeze1 = accountFreezeMapper.selectById(xid);
        if ((accountFreeze1 != null) && (accountFreeze1.getState() == AccountFreeze.State.CANCEL))
        {
            //如果已经存在则证明Cancel已经执行，拒绝执行try业务
            log.warn("出现业务悬挂！，事务id为" + xid);
            return;
        }

        //构建一个实体类对象
        AccountFreeze accountFreeze = new AccountFreeze();
        //设置xid
        accountFreeze.setXid(xid);
        //设置用户的id
        accountFreeze.setUserId(userId);
        //设置冻结的金额
        accountFreeze.setFreezeMoney(money);
        //设置事务状态
        accountFreeze.setState(AccountFreeze.State.TRY);
        //记录冻结金额和事务状态到account_freeze表
        log.debug("开始冻结金额，金额为" + money);
        accountFreezeMapper.insert(accountFreeze);
        //扣除可用的余额
        log.debug("开始扣除可用的余额");
        accountMapper.deduct(userId, money);


    }

    @Override
    public boolean confirm(BusinessActionContext context)
    {
        //confirm方法，完成资源操作业务

        //获得xid
        String xid = context.getXid();
        log.debug("开始执行confirm方法，xid为" + xid);
        //根据xid删除account_freeze表的冻结记录
        log.debug("开始删除冻结记录");
        int delete = accountFreezeMapper.deleteById(xid);
        return delete == 1;
    }

    @Override
    @Transactional
    public boolean cancel(BusinessActionContext context)
    {
        //cancel，预留资源释放，try的反向操作

        //获得xid
        String xid = context.getXid();
        log.debug("开始执行cancel方法，xid为" + xid);


        //查询冻结记录
        log.debug("开始查询冻结记录");
        AccountFreeze accountFreeze = accountFreezeMapper.selectById(xid);
        //判断是否出现空回滚
        if (accountFreeze == null || accountFreeze.getXid() == null)
        {
            //出现空回滚，需要将冻结记录写入到表中，设置状态为cancel
            log.warn("出现空回滚！ 事务id为" + xid);
            //获得userId
            String userId = (String) context.getActionContext("userId");
            //构建一个实体类对象
            accountFreeze = new AccountFreeze();
            //设置xid
            accountFreeze.setXid(xid);
            //设置用户的id
            accountFreeze.setUserId(userId);
            //设置冻结的金额
            accountFreeze.setFreezeMoney(0);
            //设置事务状态
            accountFreeze.setState(AccountFreeze.State.CANCEL);
            log.debug("创建冻结记录，并将冻结金额设置为0");
            accountFreezeMapper.insert(accountFreeze);
            return true;
        }

        //判断幂等，也就是判断状态是否为cancel
        if (accountFreeze.getState() == AccountFreeze.State.CANCEL)
        {
            log.debug("出现幂等问题！ 事务id为" + xid);
            //已经执行过一次或者多次
            return true;
        }

        //设置金额
        accountFreeze.setFreezeMoney(0);
        //设置状态
        accountFreeze.setState(AccountFreeze.State.CANCEL);
        log.debug("开始将冻结金额设置为0");
        int update = accountFreezeMapper.updateById(accountFreeze);
        //恢复可用余额
        log.debug("开始恢复可用余额");
        accountMapper.refund(accountFreeze.getUserId(), (Integer) context.getActionContext("money"));
        return update == 1;
    }
}
