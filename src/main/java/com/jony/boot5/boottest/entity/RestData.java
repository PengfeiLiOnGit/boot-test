package com.jony.boot5.boottest.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.sql.Timestamp;

@Data
@Entity
@RestResource(path = "rs",rel = "restdata")
public class RestData {

    @Id
    @GenericGenerator(strategy = "uuid",name = "ugen")
    @GeneratedValue(generator = "ugen")
    private String id;
    private String name;
    private Timestamp createDate;

    @PrePersist
    void init(){
        createDate = new Timestamp(System.currentTimeMillis());
    }
}
