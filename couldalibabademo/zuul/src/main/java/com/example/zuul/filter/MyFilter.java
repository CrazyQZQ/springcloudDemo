package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class MyFilter extends ZuulFilter {
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
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
//        ctx.setSendZuulResponse(true);
        System.out.println("经过zuul过滤器》》》》");
        parameterMap.forEach((k, v) -> {
            System.out.println("key: " + k + "-value: " + v);
        });
        return null;
    }
}
