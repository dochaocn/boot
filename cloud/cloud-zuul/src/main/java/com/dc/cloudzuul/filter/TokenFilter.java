package com.dc.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class TokenFilter extends ZuulFilter {

    /**
        pre:主要用在路由映射的阶段是寻找路由映射表的
        routing:具体的路由转发过滤器是在routing路由器，具体的请求转发的时候会调用
        post:当routing，error运行完后才会调用该过滤器，是在最后阶段的
        error:一旦前面的过滤器出错了，会调用error过滤器。
    */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        try {
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for (Cookie cookie:cookies) {
                    if ("token".equals(cookie.getName())){
                        log.info("token={}",cookie.getValue());
                        return null;
                    }
                }
            }
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("无效用户");
            log.info("无效用户");
        } catch (Exception e) {
            context.set("error.status_code",401);
            context.set("error.exception",e);
            context.set("error.message","系统错误");
        }
        return null;
    }
}
