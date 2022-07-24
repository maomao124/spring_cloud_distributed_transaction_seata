package mao.accountservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.accountservice.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.accountservice.mapper
 * Interface(接口名): AccountMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Mapper
public interface AccountMapper extends BaseMapper<Account>
{
    /**
     * 扣钱
     *
     * @param userId 要扣钱的用户id
     * @param money  扣的钱的数量
     * @return 影响行数
     */
    @Update("update account_tbl set money = money - ${money} where user_id = #{userId}")
    int deduct(@Param("userId") String userId, @Param("money") int money);

    /**
     * 退款
     *
     * @param userId 要退款的用户id
     * @param money  钱的数量
     * @return 影响行数
     */
    @Update("update account_tbl set money = money + ${money} where user_id = #{userId}")
    int refund(@Param("userId") String userId, @Param("money") int money);
}
