package com.dc.demo.other;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MvcInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("执行MvcInterceptor中preHandle......");
        log.info(request.getRequestURI());
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        log.info("执行MvcInterceptor中postHandle......");
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        log.info("本次请求处理时间为:" + (endTime - startTime) + "ms");
        request.setAttribute("handlingTime", endTime - startTime);
    }

}
