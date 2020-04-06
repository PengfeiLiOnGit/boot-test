package com.jony.boot5.boottest.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

//JPA entity
@Data
//@NoArgsConstructor(access=AccessLevel.PRIVATE)
@Entity
//@Table(name = "country")
public class Country {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    private String countryname;

    private String countrycode;

    private byte[] img;

    private Timestamp now;

    @Column(name = "update_date")
    private Timestamp update;

    @PrePersist
    void createDate() {
        now = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    void updateDate(){
        update = new Timestamp(System.currentTimeMillis());
    }
}
