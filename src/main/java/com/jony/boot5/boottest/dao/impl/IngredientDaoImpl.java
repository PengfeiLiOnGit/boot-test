package com.jony.boot5.boottest.dao.impl;

import com.jony.boot5.boottest.dao.IngredientDao;
import com.jony.boot5.boottest.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IngredientDaoImpl implements IngredientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Ingredient> findAll() {
        
//        return jdbcTemplate.query("select * from ingredient ", new RowMapper<Ingredient>() {
//            @Override
//            public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return new Ingredient(rs.getString("id"),
//                        rs.getString("name"),
//                        Ingredient.Type.SAUCE);
//            }
//        });

        return jdbcTemplate.query("select * from ingredient ", IngredientDaoImpl::rowMapper);
    }

    @Override
    public Ingredient findById(long id) {
        return jdbcTemplate.queryForObject("select * from ingredient where id = ?",((rs, rowNum) -> {
            return rowMapper(rs,rowNum);
        }));
    }

    public static Ingredient rowMapper(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into ingredient (id,name,type) values (?,?,?)",
                ingredient.getId(),ingredient.getName(),ingredient.getType().toString());
        return ingredient;
    }
}
