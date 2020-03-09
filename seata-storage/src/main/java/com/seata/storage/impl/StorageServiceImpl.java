package com.seata.storage.impl;

import api.StorageService;
import com.sentinel.dao.dao.TstorageDtoMapper;
import com.sentinel.dao.dto.TstorageDto;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @program: sentinel-dubbo
 * @description:
 * @author: lch
 * @create: 2020-03-06 17:21
 **/
@Service(interfaceClass = StorageService.class,version = "1.0.0")
@Component
public class StorageServiceImpl implements StorageService {

    @Autowired
    private TstorageDtoMapper tstorageDtoMapper;

    @Override
    @Transactional
    public String decStorage(String code) {
        Example example = new Example(TstorageDto.class);
        example.createCriteria().andEqualTo("commodityCode",code);
        TstorageDto ts = tstorageDtoMapper.selectOneByExample(example);
        int count = ts.getCount();
        count--;
        ts.setCount(count);
        int res = tstorageDtoMapper.updateByPrimaryKeySelective(ts);
        int i = 1/0;
        if(res > 0){
            return "success";
        }
        return "fail";
    }
}
