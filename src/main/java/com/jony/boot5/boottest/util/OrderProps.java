package com.jony.boot5.boottest.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Component
@ConfigurationProperties(prefix = "taco.orders")
/**
 * 使用bean 配置为一个配置类
 */

@Validated // 编译验证
public class OrderProps {

    @Max(value = 30)
    @Min(value = 5)
    private int pageSize;
}
