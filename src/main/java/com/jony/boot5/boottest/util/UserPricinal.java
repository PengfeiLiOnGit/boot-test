package com.jony.boot5.boottest.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * pricinale 接口
 */
@Slf4j
@Data
public class UserPricinal implements Principal {
    //    返回的名称
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        UserPricinal pricinal = new UserPricinal();
        pricinal.setName("username");

        log.info(pricinal.getName());
    }
}
