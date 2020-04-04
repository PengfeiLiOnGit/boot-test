package com.jony.boot5.boottest.dao.impl;

import com.jony.boot5.boottest.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDaoImpl {
    Order save(Order order);
}
