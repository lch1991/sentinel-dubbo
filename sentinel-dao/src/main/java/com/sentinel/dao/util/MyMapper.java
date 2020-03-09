package com.sentinel.dao.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper
 * @author lch
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper {
}
