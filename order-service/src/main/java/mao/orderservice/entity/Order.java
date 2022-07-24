package mao.orderservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.orderservice.entity
 * Class(类名): Order
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:46
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@TableName("order_tbl")
public class Order
{
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Integer money;

    /**
     * Instantiates a new Order.
     */
    public Order()
    {

    }

    /**
     * Instantiates a new Order.
     *
     * @param id            the id
     * @param userId        the user id
     * @param commodityCode the commodity code
     * @param count         the count
     * @param money         the money
     */
    public Order(Long id, String userId, String commodityCode, Integer count, Integer money)
    {
        this.id = id;
        this.userId = userId;
        this.commodityCode = commodityCode;
        this.count = count;
        this.money = money;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId()
    {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    /**
     * Gets commodity code.
     *
     * @return the commodity code
     */
    public String getCommodityCode()
    {
        return commodityCode;
    }

    /**
     * Sets commodity code.
     *
     * @param commodityCode the commodity code
     */
    public void setCommodityCode(String commodityCode)
    {
        this.commodityCode = commodityCode;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public Integer getCount()
    {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(Integer count)
    {
        this.count = count;
    }

    /**
     * Gets money.
     *
     * @return the money
     */
    public Integer getMoney()
    {
        return money;
    }

    /**
     * Sets money.
     *
     * @param money the money
     */
    public void setMoney(Integer money)
    {
        this.money = money;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("id：").append(id).append('\n');
        stringbuilder.append("userId：").append(userId).append('\n');
        stringbuilder.append("commodityCode：").append(commodityCode).append('\n');
        stringbuilder.append("count：").append(count).append('\n');
        stringbuilder.append("money：").append(money).append('\n');
        return stringbuilder.toString();
    }
}
