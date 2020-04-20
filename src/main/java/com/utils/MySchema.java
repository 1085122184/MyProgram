package com.utils;


import io.protostuff.runtime.RuntimeSchema;

public class MySchema {
    public static <T> RuntimeSchema<T> GetSchema(Class<T> typeClass) {
        return  RuntimeSchema.createFrom(typeClass);
    }
}
