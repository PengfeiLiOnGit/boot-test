package com.jony.boot5.boottest.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public SysUser toUser(PasswordEncoder passwordEncoder) {
        return new SysUser(username,passwordEncoder.encode(password));
    }
}
