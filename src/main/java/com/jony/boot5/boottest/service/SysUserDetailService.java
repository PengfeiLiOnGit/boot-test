package com.jony.boot5.boottest.service;

import com.jony.boot5.boottest.entity.SysUser;
import com.jony.boot5.boottest.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
/**
 * 用户详情service
 */
public class SysUserDetailService implements UserDetailsService {
    @Autowired
    private SysUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 返回继承userDetails的Sysuser
        SysUser user = repository.findByUsername(s);
        if(user!=null){
            return user;
        }
        throw new UsernameNotFoundException("USER:"+s+" not found");
    }
}
