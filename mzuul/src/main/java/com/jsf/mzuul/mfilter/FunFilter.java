package com.jsf.mzuul.mfilter;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsf.mzuul.config.DataFilterConfig;
import com.jsf.mzuul.util.JwtUtil;
import com.jsf.mzuul.util.PathUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
@Component
 public class FunFilter extends ZuulFilter {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    DataFilterConfig dataFilterConfig;

    /**
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
 
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter：逻辑是否要过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //路径与配置的相匹配，则执行过滤
        RequestContext ctx = RequestContext.getCurrentContext();
        for (String pathPattern : dataFilterConfig.getFunPath()) {
            if (PathUtil.isPathMatch(pathPattern, ctx.getRequest().getRequestURI())) {
                return true;
            }
        }
        return false;
    }


    /**
     * 执行过滤器逻辑，验证token
     *
     * @return
     */
    @Override
    public Object run() {
       

        return null;
    }


    
}
