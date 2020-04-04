package com.jony.boot5.boottest.service.impl;

import com.jony.boot5.boottest.entity.Country;
import com.jony.boot5.boottest.mapper.CountryMapper;
import com.jony.boot5.boottest.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CountryServiceImpl implements ICountryService {
    @Autowired
    private CountryMapper mapper;

    @Override
    public List<Country> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Country selectById(String id) {
        return mapper.selectById(id);
    }
}
