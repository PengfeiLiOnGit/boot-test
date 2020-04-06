package com.jony.boot5.boottest.controller;

import com.jony.boot5.boottest.entity.RestData;
import com.jony.boot5.boottest.repository.RestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RepositoryRestController
public class RestfulDataController {
    @Autowired
    private RestDataRepository repository;

    @GetMapping(path = "/rs/sign/{id}")
    public ResponseEntity<RestData> takeRestData(@PathVariable("id") String id){
        Optional<RestData> data = repository.findById(id);
        return new ResponseEntity<RestData>(data.get(),HttpStatus.OK);
    }
}
