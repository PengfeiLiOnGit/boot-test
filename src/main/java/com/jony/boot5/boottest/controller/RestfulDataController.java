package com.jony.boot5.boottest.controller;

import com.jony.boot5.boottest.entity.RestData;
import com.jony.boot5.boottest.repository.RestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RepositoryRestController
public class RestfulDataController {
    @Autowired
    private RestDataRepository repository;

    /**
     * 必须保证path 的第一个前缀与api 前缀一致
     * 返回数据前1、返回responseEntity 对象 或添加 @ResponseBody注解
     * @param id
     * @return
     */
    @GetMapping(path = "/rs/sign/{id}")
    public ResponseEntity<RestData> takeRestData(@PathVariable("id") String id){
        // 声明一个pageRequest
//        PageRequest request = PageRequest.of(0,12,Sort.by("createDate").descending());
        // 查询分页数据
//        Page<RestData> page = repository.findAll(request);
        // 获取page的数据对象
//        List<RestData> list = page.getContent();

        Optional<RestData> data = repository.findById(id);
        return new ResponseEntity<RestData>(data.get(),HttpStatus.OK);
    }
}
