package mao.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.orderservice.feign
 * Interface(接口名): StorageFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 21:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@FeignClient("storage-service")
public interface StorageFeignClient
{
    /**
     * 扣减库存
     * @param code code
     * @param count 数量
     */
    @PutMapping("/storage/{code}/{count}")
    void deduct(@PathVariable("code") String code, @PathVariable("count") Integer count);
}
