package com.jony.boot5.boottest.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//JPA entity
@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@Entity
//@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue
    private String id;

    private String countryname;

    private String countrycode;

    private byte[] img;

    private Date now;

    @PrePersist
    void createDate(){
        now = new Date();
    }
}
