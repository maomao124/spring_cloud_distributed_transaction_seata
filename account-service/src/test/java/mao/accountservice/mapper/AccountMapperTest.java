package mao.accountservice.mapper;

import mao.accountservice.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.accountservice.mapper
 * Class(测试类名): AccountMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 21:35
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class AccountMapperTest
{
    @Resource
    private AccountMapper accountMapper;

    @Test
    void testQuery()
    {
        List<Account> accounts = accountMapper.selectList(null);
        System.out.println(accounts);
    }
}