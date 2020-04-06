package com.jony.boot5.boottest.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
/**
 * 注册bean 重写matcher 组件
 */
@ConfigurationProperties(prefix = "custom.csrf")
public class CsrfRequestMacher implements RequestMatcher {
    private final HashSet<String> allowedMethods = new HashSet<>(
            Arrays.asList("GET", "HEAD", "TRACE", "OPTIONS"));

    private Set<String> excludeUrls;

    public void setExcludeUrls(Set<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
//        如果是设置在允许范围内的post或put 等请求则直接放过
        for (String exclude:excludeUrls) {
            if(request.getServletPath().startsWith(exclude)){
                return false;
            }
        }
//        if (excludeUrls.contains(request.getServletPath())) {
//            return false;
//        }
        return !this.allowedMethods.contains(request.getMethod());
    }
}
