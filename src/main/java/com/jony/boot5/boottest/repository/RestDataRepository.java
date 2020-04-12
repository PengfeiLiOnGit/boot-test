package com.jony.boot5.boottest.repository;

import com.jony.boot5.boottest.entity.RestData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
/**
 * 在分页的情况下继承pageing sort
 */
public interface RestDataRepository extends PagingAndSortingRepository<RestData,String> {

}
