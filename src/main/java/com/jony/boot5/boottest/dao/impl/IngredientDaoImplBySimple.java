package com.jony.boot5.boottest.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jony.boot5.boottest.dao.IngredientDao;
import com.jony.boot5.boottest.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//@Repository
/**
 * 通过simple - insert 实现数据插入
 */
public class IngredientDaoImplBySimple implements IngredientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //    JDBC 的封装
    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;
    private ObjectMapper objectMapper;

    public IngredientDaoImplBySimple() {
        orderInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("ingredient").usingGeneratedKeyColumns("id");
        orderTacoInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("");
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findById(long id) {
        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        Map<String,Object> map = objectMapper.convertValue(ingredient,Map.class);
//        使用execute 执行插入操作
        orderInserter.executeAndReturnKey(map);
        return ingredient;
    }
}
