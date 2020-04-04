package com.jony.boot5.boottest.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jony.boot5.boottest.dao.OrderDao;
import com.jony.boot5.boottest.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public Order save(Order order) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template).withTableName("Taco_Order");
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = mapper.convertValue(order,Map.class);
        insert.execute(map);
        return order;
    }
}
