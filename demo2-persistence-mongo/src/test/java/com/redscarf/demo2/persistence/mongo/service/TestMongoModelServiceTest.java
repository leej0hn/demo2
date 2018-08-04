package com.redscarf.demo2.persistence.mongo.service;

import com.redscarf.demo2.BaseDaoTest;
import com.redscarf.demo2.common.mongo.model.TestMongoModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMongoModelServiceTest extends BaseDaoTest {
    @Autowired
    TestMongoModelService service;

    @Test
    public void testSave(){
        TestMongoModel mongoModel = new TestMongoModel();
        mongoModel.setName("Lee");
        mongoModel.setAge(18);
        service.save(mongoModel);
    }

    @Test
    public void testFindAll(){
        List<TestMongoModel> all = service.findAll();
        System.out.println(all);
    }
}
