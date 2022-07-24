package mao.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.orderservice.feign
 * Interface(接口名): AccountFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 21:04
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@FeignClient("account-service")
public interface AccountFeignClient
{
    /**
     * 扣钱
     *
     * @param userId 要扣钱的用户id
     * @param money  扣的钱的数量
     * @return ResponseEntity
     */
    @PutMapping("/account/{userId}/{money}")
    ResponseEntity<Void> deduct(@PathVariable("userId") String userId, @PathVariable("money") Integer money);
}
