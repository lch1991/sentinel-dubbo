package com.seate.order.impl;

import api.OrderService;
import api.StorageService;
import com.sentinel.dao.dao.TorderDtoMapper;
import com.sentinel.dao.dto.TorderDto;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @program: sentinel-dubbo
 * @description:
 * @author: lch
 * @create: 2020-03-06 12:37
 **/
@Service(interfaceClass = OrderService.class,version = "1.0.0")
@Component
public class OrderServiceImpl implements OrderService {

    private Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private TorderDtoMapper torderDtoMapper;

    @Reference(version = "1.0.0")
    private StorageService storageService;

    @GlobalTransactional
    @Override
    public void createOrder() {
        try {
            System.out.println("开始全局事务。XID=" + RootContext.getXID());
            // 减库存
            String ss = storageService.decStorage("TT");
            if(!"success".equals(ss)){
                throw new RuntimeException("分布式事务异常...");
            }
            // 下订单
            TorderDto torderDto = new TorderDto();
            torderDto.setUserId("1111");
            torderDto.setOrderNo(UUID.randomUUID().toString());
            torderDto.setCommodityCode("TT");
            torderDto.setAmount(20.00);
            torderDto.setCount(10);
            torderDtoMapper.insertSelective(torderDto);
        }catch (Exception e){
           log.error(e.getMessage(),e);
        }
    }
}
