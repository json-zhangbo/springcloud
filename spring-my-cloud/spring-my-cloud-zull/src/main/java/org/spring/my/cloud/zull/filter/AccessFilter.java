package org.spring.my.cloud.zull.filter;

import com.google.common.collect.Maps;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimiter;
import com.netflix.zuul.ZuulFilter;  
import com.netflix.zuul.context.RequestContext;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;  

@Component  
public class AccessFilter extends ZuulFilter{
	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);  

   private Map<String, RateLimiter> map =Maps.newConcurrentMap();
    @Override  
    public String filterType() {  
        //前置过滤器  
        return "pre";  
    }  
  
    @Override  
    public int filterOrder() {  
        //优先级，数字越大，优先级越低  
    	  
    	// 这边的order一定要大于org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter的order
    	        
    	// 也就是要大于5
    	        
    	// 否则，RequestContext.getCurrentContext()里拿不到serviceId等数据。
        //return 0;  
    	 
    	return Ordered.LOWEST_PRECEDENCE
    	;
    }  
  
    public boolean shouldFilter() {  
        //是否执行该过滤器，true代表需要过滤  
        return false;  
    }  
  
    public Object run() {  
        RequestContext ctx = RequestContext.getCurrentContext();  
        HttpServletRequest request = ctx.getRequest();  
  
        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());  
        List<String> cookies = Collections.list(request.getHeaders("cookie"));
        HttpSession session = request.getSession(false);
        if (session != null && cookies.stream().noneMatch(c -> c.startsWith("SESSION="))) {
        	ctx.addZuulRequestHeader("cookie", "SESSION=" + session.getId());
        }
        // String serviceId  = ( String ) ctx.get(SERVICE_ID_KEY);
        //获取传来的参数accessToken  
        Object accessToken = request.getParameter("accessToken");  
        if(accessToken == null) {  
            log.warn("access token is empty");  
            //过滤该请求，不往下级服务去转发请求，到此结束  
            ctx.setSendZuulResponse(false);  
            ctx.setResponseStatusCode(401);  
            ctx.setResponseBody("{\"result\":\"accessToken is empty!\"}");  
            return null;  
        }  
        //如果有token，则进行路由转发  
        log.info("access token ok");  
        //这里return的值没有意义，zuul框架没有使用该返回值  
        return null;  
    }  
}
