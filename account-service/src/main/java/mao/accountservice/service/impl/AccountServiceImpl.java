package mao.accountservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.accountservice.mapper.AccountMapper;
import mao.accountservice.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.accountservice.service.impl
 * Class(类名): AccountServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Service
@Slf4j
public class AccountServiceImpl implements AccountService
{

    @Resource
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void deduct(String userId, int money)
    {
        log.info("开始扣款");
        try
        {
            accountMapper.deduct(userId, money);
        }
        catch (Exception e)
        {
            throw new RuntimeException("扣款失败！", e);
        }
        log.info("扣款成功");
    }
}
