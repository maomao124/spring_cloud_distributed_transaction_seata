package mao.accountservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.accountservice.entity
 * Class(类名): Account
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:26
 * Version(版本): 1.0
 * Description(描述)： 账户表
 */

@TableName("account_tbl")
public class Account
{
    @TableId
    private Long id;
    private String userId;
    private Integer money;

    /**
     * Instantiates a new Account.
     */
    public Account()
    {

    }

    /**
     * Instantiates a new Account.
     *
     * @param id     the id
     * @param userId the user id
     * @param money  the money
     */
    public Account(Long id, String userId, Integer money)
    {
        this.id = id;
        this.userId = userId;
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
        stringbuilder.append("money：").append(money).append('\n');
        return stringbuilder.toString();
    }
}
