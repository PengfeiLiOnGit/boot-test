package com.jony.boot5.boottest.mapper;

import com.jony.boot5.boottest.entity.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {
    List<Country> selectAll();

    Country selectById(String id);
}
