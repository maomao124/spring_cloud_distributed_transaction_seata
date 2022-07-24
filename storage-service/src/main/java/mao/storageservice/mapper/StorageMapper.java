package mao.storageservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.storageservice.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.storageservice.mapper
 * Interface(接口名): StorageMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 21:23
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Mapper
public interface StorageMapper extends BaseMapper<Storage>
{

    /**
     * 扣减库存
     *
     * @param commodityCode 商品编码
     * @param count         扣减的数量
     * @return 影响行数
     */
    @Update("update storage_tbl set `count` = `count` - #{count} where commodity_code = #{code}")
    int deduct(@Param("code") String commodityCode, @Param("count") int count);

}
