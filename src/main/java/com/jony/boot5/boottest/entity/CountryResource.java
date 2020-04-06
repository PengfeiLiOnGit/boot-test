package com.jony.boot5.boottest.entity;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Timestamp;

@Getter
//指定resource 资源单个为 country，集合为countries
@Relation(value = "country",collectionRelation = "countries")
public class CountryResource extends RepresentationModel<CountryResource> {
    private String countryname;

    private String countrycode;

    private byte[] img;

    private Timestamp now;

    private Timestamp update;

    public CountryResource(Country country) {
        this.countryname = country.getCountryname();
        this.countrycode = country.getCountrycode();
        this.img = country.getImg();
        this.now = country.getNow();
        this.update = country.getUpdate();
    }
}
