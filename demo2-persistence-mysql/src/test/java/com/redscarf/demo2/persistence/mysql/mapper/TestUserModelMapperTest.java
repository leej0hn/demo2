
package com.redscarf.demo2.persistence.mysql.mapper;

import com.github.pagehelper.PageHelper;
import com.redscarf.demo2.common.mysql.model.TestUserModel;
import com.redscarf.demo2.persistence.mysql.BaseDaoTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2017/12/01
 * <p>Version: 1.0
 */
public class TestUserModelMapperTest extends BaseDaoTest {
    @Autowired
    TestUserModelMapper mapper;

    @Test
    public void testInsert() throws Exception{
        TestUserModel model = new TestUserModel();
        model.setAge(18);
        model.setName("JackQ");
        model.setScope(99);
        model.setSubject("math");
        int insert = mapper.insert(model);
        System.out.println("id : " + model.getId() + " --- insert : " + insert);
    }

    @Test
    public void testInsertCustom() throws Exception{
        TestUserModel model = new TestUserModel();
        model.setAge(18);
        model.setName("JackQ");
        model.setScope(99);
        model.setSubject("math");
        mapper.insertCustom(model);
        System.out.println("id : " + model.getId() );
    }

    @Test
    public void testUserGroupBySubject() throws Exception{
        String[] names = new String[]{"JackQ","LeeO","Cheer","Tom","PPT"};
        List<TestUserModel> testUserModels = mapper.userGroupBySubject(names, 1);
        System.out.println(testUserModels);
    }

    @Test
    public void testSelectOne() throws Exception {
        TestUserModel select = new TestUserModel();
        select.setName("JackQ");
        TestUserModel model = mapper.selectOne(select);
        System.out.println( model );
    }

    @Test
    public void testSelect() throws Exception{
        TestUserModel select = new TestUserModel();
        select.setName("JackQ");
        List<TestUserModel> model = mapper.select(select);
        System.out.println( model );
    }

    @Test
    public void testSelectAll() throws Exception{
        int pageNum = 1;
        int pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<TestUserModel> testUserModels = mapper.selectAll();
        System.out.println( testUserModels );

    }

    @Test
    public void testSelectAll3(){
        System.out.println(mapper.selectAll3());
    }

}
