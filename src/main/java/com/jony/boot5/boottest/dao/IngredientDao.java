package com.jony.boot5.boottest.dao;

import com.jony.boot5.boottest.entity.Ingredient;

import java.util.List;

public interface IngredientDao {
    List<Ingredient> findAll();
    Ingredient findById(long id);
    Ingredient save(Ingredient ingredient);

}
