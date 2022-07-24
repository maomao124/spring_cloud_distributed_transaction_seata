package mao.storageservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.storageservice.mapper.StorageMapper;
import mao.storageservice.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.storageservice.service.impl
 * Class(类名): StorageServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/24
 * Time(创建时间)： 21:26
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Service
@Slf4j
public class StorageServiceImpl implements StorageService
{

    @Resource
    private StorageMapper storageMapper;

    @Override
    @Transactional
    public void deduct(String commodityCode, int count)
    {
        log.info("开始扣减库存");
        try
        {
            storageMapper.deduct(commodityCode, count);
        }
        catch (Exception e)
        {
            throw new RuntimeException("扣减库存失败！", e);
        }
        log.info("扣减库存成功");
    }
}
