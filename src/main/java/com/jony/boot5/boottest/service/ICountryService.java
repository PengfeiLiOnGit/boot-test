package com.jony.boot5.boottest.service;

import com.jony.boot5.boottest.entity.Country;

import java.util.List;

public interface ICountryService {
    List<Country> selectAll();

    Country selectById(String id);
}
