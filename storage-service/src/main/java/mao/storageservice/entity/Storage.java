package mao.storageservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.storageservice.entity
 * Class(类名): Storage
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 21:21
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@TableName("storage_tbl")
public class Storage
{
    @TableId
    private Long id;
    private String commodityCode;
    private Integer count;

    /**
     * Instantiates a new Storage.
     */
    public Storage()
    {

    }

    /**
     * Instantiates a new Storage.
     *
     * @param id            the id
     * @param commodityCode the commodity code
     * @param count         the count
     */
    public Storage(Long id, String commodityCode, Integer count)
    {
        this.id = id;
        this.commodityCode = commodityCode;
        this.count = count;
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

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("id：").append(id).append('\n');
        stringbuilder.append("commodityCode：").append(commodityCode).append('\n');
        stringbuilder.append("count：").append(count).append('\n');
        return stringbuilder.toString();
    }
}
