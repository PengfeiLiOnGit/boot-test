package com.jony.boot5.boottest.config;

import com.jony.boot5.boottest.entity.Country;
import com.jony.boot5.boottest.entity.CountryResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC config
 */
@Configuration
public class MvcResolveConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    @Profile({"prod"})
//    非生产环境
//    @Profile({"!prod"})
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Profile({"dev"})
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    /**
     * 配置自定义超链接
     */
    public RepresentationModelProcessor<PagedModel<Country>> countryProcessor(EntityLinks links) {
        return new RepresentationModelProcessor<PagedModel<Country>>() {
            @Override
            public PagedModel<Country> process(PagedModel<Country> model) {
                model.add(
                        links.linkFor(Country.class)
//                                针对url
                                .slash("resource")
                                .withRel("resources")
                );
                return model;
            }
        };
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
