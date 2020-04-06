package com.jony.boot5.boottest.controller;

import com.jony.boot5.boottest.entity.Country;
import com.jony.boot5.boottest.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//处理rest请求，accept 内容为json格式
@RequestMapping(value = "/rest", produces = {"application/json"})
//允许跨域请求
@CrossOrigin(origins = {"*"})
public class RestfulController {
    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Iterable findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Country> findById(@PathVariable("id") String id) {
        Optional<Country> optional = repository.findById(id);
//        返回状态码
        if (optional.isPresent()) {
//            返回ok
            return new ResponseEntity<Country>(optional.get(), HttpStatus.OK);
        }
//返回404
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * 处理post请求
     *
     * @return
     */
    @PostMapping(consumes = {"application/json"})
//    consumes 指定用户输入的json数据
    @ResponseStatus(code = HttpStatus.CREATED)
//    返回created 状态码
    public Country postCountry(@RequestBody Country country) {
        Country result = repository.save(country);
        return result;
    }

    @PutMapping(path = "/{id}",consumes = {"application/json"})
    /**
     * 全部更新或插入
     */
    public Country putCountry(@RequestBody Country country,@PathVariable("id") String id){
        country.setId(id);
        return repository.save(country);
    }

    @PatchMapping(path = "/{id}")
    /**
     * 更新
     */
    public Country patchCountry(@PathVariable("id")String id,@RequestBody Country patch){
        Country country = repository.findById(id).get();
        if(country!=null){
//            IF 判断设置
        }
        return repository.save(country);
    }
}
