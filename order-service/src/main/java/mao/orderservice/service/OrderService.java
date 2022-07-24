package mao.orderservice.service;

import mao.orderservice.entity.Order;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.orderservice.service
 * Interface(接口名): OrderService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:48
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface OrderService
{
    /**
     * 创建订单
     * @param order 订单对象
     * @return 订单的id
     */
    Long create(Order order);
}
