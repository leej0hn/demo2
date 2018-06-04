package com.redscarf.demo2.web.interceptor;

import com.redscarf.demo2.web.configuration.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2016/7/18
 * <p>Version: 1.0
 */
@Slf4j
@Component
public class IpInterceptor implements HandlerInterceptor {

    private static final String TOKEN_HEADER = "token_header";
    private static final String TOKEN_PARAMETER = "token_parameter";
    private static final String ALL_ALLOW = "/*";

    @Autowired
    private WebConfig config;

    public IpInterceptor(){
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if( ALL_ALLOW.equals(config.getIps()) || config.getIps().contains(request.getRemoteHost()) ||
                ( request.getHeader(TOKEN_HEADER)!= null && request.getHeader(TOKEN_HEADER).equals(config.getTokenHeader()) ) ||
                ( request.getParameter(TOKEN_PARAMETER) != null && request.getParameter(TOKEN_PARAMETER).equals(config.getTokenHeader()) )
                ){
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
