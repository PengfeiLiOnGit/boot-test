package com.jony.boot5.boottest.repository;

import com.jony.boot5.boottest.entity.SysUser;
import org.springframework.data.repository.CrudRepository;

public interface SysUserRepository extends CrudRepository<SysUser,String> {
    SysUser findByUsername(String username);
}

