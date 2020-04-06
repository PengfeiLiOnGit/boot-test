package com.jony.boot5.boottest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RequestMatcher requestMatcher;

//    @Bean
//    public RequestMatcher customMacher(){
//        return new CsrfRquestMacher();
//    }

    @Override
    /**
     * 用户验证配置
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        注入service- 用来方法引用
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    /**
     * http 网络访问配置
     */
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

//                首先验证需要用户验证的URL
                .antMatchers("/design", "/orders", "/security")
//                .hasRole("USER")
                .access("hasRole('ROLE_USER')")
//                验证针对其他请求的matcher  -  自定义matcher
//                允许其他验证
                .antMatchers("/", "/**")
                .permitAll()
                .and()

                .csrf()
                .requireCsrfProtectionMatcher(requestMatcher)

                .and()
                .formLogin()
                .loginPage("/login")
//        .loginProcessingUrl("/authenticate")
//        .usernameParameter("username")
//        .passwordParameter("password")

//                第二个参数为强制参数,强制重定向到design
//        .defaultSuccessUrl("/design",true)
                .and()
                .logout()
                .logoutSuccessUrl("/")

//                .and()
//                针对rest接口放宽csrf
//                .antMatcher("/rest")
//                .csrf()
//                .disable()
        ;
    }
}
