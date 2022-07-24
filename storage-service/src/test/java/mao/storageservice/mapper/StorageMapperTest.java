package mao.storageservice.mapper;

import mao.storageservice.entity.Storage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.storageservice.mapper
 * Class(测试类名): StorageMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 21:45
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class StorageMapperTest
{
    @Resource
    private StorageMapper storageMapper;

    @Test
    void testQuery()
    {
        List<Storage> storages = storageMapper.selectList(null);
        System.out.println(storages);
    }
}