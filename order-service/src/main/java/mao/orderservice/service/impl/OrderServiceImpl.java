package mao.orderservice.service.impl;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import mao.orderservice.entity.Order;
import mao.orderservice.mapper.OrderMapper;
import mao.orderservice.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.orderservice.service.impl
 * Class(类名): OrderServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService
{

    @Resource
    private AccountClient accountClient;
    @Resource
    private StorageClient storageClient;
    @Resource
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public Long create(Order order)
    {
        try
        {
            // 创建订单
            orderMapper.insert(order);
            // 扣用户余额
            accountClient.deduct(order.getUserId(), order.getMoney());
            // 扣库存
            storageClient.deduct(order.getCommodityCode(), order.getCount());

        }
        catch (FeignException e)
        {
            log.error("下单失败，原因:{}", e.contentUTF8(), e);
            throw new RuntimeException(e.contentUTF8(), e);
        }
        catch (Exception e)
        {
            log.error("下单失败");
            throw new RuntimeException(e);
        }
        return order.getId();
    }
}
