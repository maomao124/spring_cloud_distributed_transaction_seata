package mao.orderservice.mapper;

import mao.orderservice.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.orderservice.mapper
 * Class(测试类名): OrderMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 21:43
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class OrderMapperTest
{

    @Resource
    private OrderMapper orderMapper;

    @Test
    void testQuery()
    {
        List<Order> orders = orderMapper.selectList(null);
        System.out.println(orders);
    }
}