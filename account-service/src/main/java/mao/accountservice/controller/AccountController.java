package mao.accountservice.controller;

import mao.accountservice.service.AccountService;
import mao.accountservice.service.AccountTCCService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.accountservice.controller
 * Class(类名): AccountController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:41
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
@RequestMapping("account")
public class AccountController
{
    @Resource
    private AccountService accountService;

    @Resource
    private AccountTCCService accountTCCService;

    /**
     * 扣钱
     *
     * @param userId 要扣钱的用户id
     * @param money  扣的钱的数量
     * @return ResponseEntity
     */
    @PutMapping("/{userId}/{money}")
    public ResponseEntity<Void> deduct(@PathVariable("userId") String userId, @PathVariable("money") Integer money)
    {
        //accountService.deduct(userId, money);
        accountTCCService.prepare(userId, money);
        return ResponseEntity.noContent().build();
    }
}
