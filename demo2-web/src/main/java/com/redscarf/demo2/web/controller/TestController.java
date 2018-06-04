package com.redscarf.demo2.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redscarf.demo2.common.exception.ServiceException;
import com.redscarf.demo2.common.mysql.model.TestUserModel;
import com.redscarf.demo2.common.vo.Response;
import com.redscarf.demo2.persistence.mysql.mapper.TestUserModelMapper;
import com.redscarf.demo2.web.configuration.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2017/01/11
 * <p>Version: 1.0
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestUserModelMapper testUserModelMapper;


    @Value("${web.ips:}")
    private String ips;

    @Autowired
    private WebConfig config;

    @RequestMapping(value = "/api/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response index() {
        return Response.ok("test");
    }



    @GetMapping("/page/test")
    public ModelAndView testPage() {
        String test = "Test Page , hello world ";
        return new ModelAndView("testPage","test",test);
    }

    @GetMapping("/api/exception")
    public Response testExcption(){
        throw new ServiceException("testException msg");
    }

    @GetMapping("/api/find")
    public Response<List<TestUserModel>> findAll(){
        List<TestUserModel> testUserModels = testUserModelMapper.selectAll();
        return Response.ok(testUserModels);
    }

    @GetMapping("/api/find2")
    public Response<PageInfo<TestUserModel>> find2(){
        int pageNum = 1;
        int pageSize = 2;
        PageHelper.startPage(pageNum, pageSize);

        List<TestUserModel> vos = testUserModelMapper.selectAll();
        return Response.ok(new PageInfo<>(vos));
    }



}
