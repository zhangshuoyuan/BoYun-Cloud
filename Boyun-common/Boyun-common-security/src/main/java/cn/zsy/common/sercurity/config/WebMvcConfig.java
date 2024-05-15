package cn.zsy.common.sercurity.config;

import cn.zsy.common.core.interceptor.HeaderInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zsy
 * @Description 拦截器配置
 */

public class WebMvcConfig implements WebMvcConfigurer
{
    /** 不需要拦截的地址 */
    public static final String[] excludeUrls = {"/login","/logout","/refresh"};

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(getHeaderInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludeUrls)
                .order(-10);
    }

    /**
     * 自定义请求头拦截器
     */
    public HeaderInterceptor getHeaderInterceptor()
    {
        return new HeaderInterceptor();
    }
}
