package mao.accountservice.service.impl;

import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import mao.accountservice.service.TCCService;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：spring_cloud_distributed_transaction_seata
 * Package(包名): mao.accountservice.service.impl
 * Class(类名): TCCServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/7/28
 * Time(创建时间)： 13:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class TCCServiceImpl implements TCCService
{

    @Override
    public void prepare(String param)
    {

    }

    @Override
    public boolean confirm(BusinessActionContext context)
    {
        return false;
    }

    @Override
    public boolean cancel(BusinessActionContext context)
    {
        return false;
    }
}
