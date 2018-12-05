package com.nfsq.yqf.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by qfyu
 * Date:2018/12/4
 * Time:21:32
 **/
//把过滤器注入到spring容器中
@Component
public class TokenFilter extends ZuulFilter {
    /**
     * 过滤器的类型
     * "pre"表示请求之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序
     * 当一个请求同时存在多个过滤器的时候的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     *判断过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器拦截逻辑顺序
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取上下文
        RequestContext context = RequestContext.getCurrentContext();
        //获取HttpRequest
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            //不会继续执行，直接返回给客户端
            context.setSendZuulResponse(false);
            context.setResponseBody("you have no authority");
            context.setResponseStatusCode(404);
            return null;
        }

        return null;
    }
}
