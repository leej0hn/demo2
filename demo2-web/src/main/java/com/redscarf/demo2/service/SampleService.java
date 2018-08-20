package com.redscarf.demo2.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @description: 方法级别 检测
 * @author: LeeJohn
 * @date: 2018/8/20 09:54
 */
@Service
public class SampleService {

    @Secured("ROLE_USER")
    public String secure() {
        return "Hello Security";
    }

    @PreAuthorize("true")
    public String authorized() {
        return "Hello World";
    }

    @PreAuthorize("false")
    public String denied() {
        return "Goodbye World";
    }

}
