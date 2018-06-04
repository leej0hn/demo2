package com.redscarf.demo2.persistence.mysql.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * @author samlen_tsoi
 * @date 2017/12/25
 */
public interface IBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
