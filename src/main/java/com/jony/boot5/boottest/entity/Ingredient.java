package com.jony.boot5.boottest.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 玉米饼
 */
@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
