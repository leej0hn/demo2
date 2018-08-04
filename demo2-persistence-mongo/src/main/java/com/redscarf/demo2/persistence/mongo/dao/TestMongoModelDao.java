package com.redscarf.demo2.persistence.mongo.dao;


import com.redscarf.demo2.common.mongo.model.TestMongoModel;
import com.redscarf.demo2.persistence.mongo.repository.CustomerRepository;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2018/8/4
 * <p>Version: 1.0
 */
public interface TestMongoModelDao extends CustomerRepository<TestMongoModel, String> {

}
