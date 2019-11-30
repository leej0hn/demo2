package com.redscarf.demo2.persistence.mongo.service;

import com.redscarf.demo2.BaseDaoTest;
import com.redscarf.demo2.common.mongo.model.TestMongoModel;
import com.redscarf.demo2.persistence.mongo.dao.TestMongoModelDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author LeeJohn
 * @date 2018-12-28 15:48
 */
public class TestMongoModelDaoTest extends BaseDaoTest {
    @Autowired
    TestMongoModelDao dao;

    @Test
    public void testSave(){
        TestMongoModel mongoModel = new TestMongoModel();
        mongoModel.setName("Lee");
        mongoModel.setAge(18);
        dao.save(mongoModel);
    }

    @Test
    public void testFindAll(){
        List<TestMongoModel> all = dao.findAll();
        System.out.println(all);
    }
}
