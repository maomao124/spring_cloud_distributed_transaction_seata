package mao.accountservice.service;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.accountservice.service
 * Interface(接口名): AccountService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface AccountService
{
    /**
     * 扣款
     *
     * @param userId 要扣钱的用户id
     * @param money  扣的钱的数量
     */
    void deduct(String userId, int money);
}
