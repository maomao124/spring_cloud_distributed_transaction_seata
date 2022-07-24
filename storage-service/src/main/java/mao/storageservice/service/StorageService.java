package mao.storageservice.service;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.storageservice.service
 * Interface(接口名): StorageService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 21:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface StorageService
{
    /**
     * 扣减库存
     *
     * @param commodityCode 商品编码
     * @param count         扣减的数量
     */
    void deduct(String commodityCode, int count);
}
