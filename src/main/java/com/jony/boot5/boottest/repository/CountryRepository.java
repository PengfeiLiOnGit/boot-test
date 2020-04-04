package com.jony.boot5.boottest.repository;

import com.jony.boot5.boottest.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country,String> {
    List<Country> findAll();
}
