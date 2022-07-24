package mao.orderservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.orderservice.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.orderservice.mapper
 * Interface(接口名): OrderMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Mapper
public interface OrderMapper extends BaseMapper<Order>
{

}
