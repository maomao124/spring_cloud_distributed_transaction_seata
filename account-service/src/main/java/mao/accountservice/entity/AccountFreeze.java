package mao.accountservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.accountservice.entity
 * Class(类名): AccountFreeze
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 20:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@TableName("account_freeze_tbl")
public class AccountFreeze
{
    @TableId(type = IdType.INPUT)
    private String xid;
    private String userId;
    private Integer freezeMoney;
    private Integer state;

    /**
     * The type State.
     */
    public static abstract class State
    {
        /**
         * The constant TRY.
         */
        public final static int TRY = 0;
        /**
         * The constant CONFIRM.
         */
        public final static int CONFIRM = 1;
        /**
         * The constant CANCEL.
         */
        public final static int CANCEL = 2;
    }

    /**
     * Instantiates a new Account freeze.
     */
    public AccountFreeze()
    {

    }

    /**
     * Instantiates a new Account freeze.
     *
     * @param xid         the xid
     * @param userId      the user id
     * @param freezeMoney the freeze money
     * @param state       the state
     */
    public AccountFreeze(String xid, String userId, Integer freezeMoney, Integer state)
    {
        this.xid = xid;
        this.userId = userId;
        this.freezeMoney = freezeMoney;
        this.state = state;
    }

    /**
     * Gets xid.
     *
     * @return the xid
     */
    public String getXid()
    {
        return xid;
    }

    /**
     * Sets xid.
     *
     * @param xid the xid
     */
    public void setXid(String xid)
    {
        this.xid = xid;
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
     * Gets freeze money.
     *
     * @return the freeze money
     */
    public Integer getFreezeMoney()
    {
        return freezeMoney;
    }

    /**
     * Sets freeze money.
     *
     * @param freezeMoney the freeze money
     */
    public void setFreezeMoney(Integer freezeMoney)
    {
        this.freezeMoney = freezeMoney;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public Integer getState()
    {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(Integer state)
    {
        this.state = state;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("xid：").append(xid).append('\n');
        stringbuilder.append("userId：").append(userId).append('\n');
        stringbuilder.append("freezeMoney：").append(freezeMoney).append('\n');
        stringbuilder.append("state：").append(state).append('\n');
        return stringbuilder.toString();
    }
}
