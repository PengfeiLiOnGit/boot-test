package com.jony.boot5.boottest.config;

import com.jony.boot5.boottest.service.SysUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysUserDetailService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    /**
     * 用户验证配置
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        注入service- 用来方法引用
        auth.userDetailsService(userDetailService)
            .passwordEncoder(passwordEncoder());
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
        http.authorizeRequests()
                .antMatchers("/design","/orders","/security")
//                .hasRole("USER")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/","/**")
                .permitAll()
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
        .logoutSuccessUrl("/");
    }
}
