package com.example.jpmccodingexercise.mapper;

import java.util.ArrayList;
import java.util.List;

public interface Mapper<T, R> {

    R map(T item);

    default List<R> mapList(List<T> items) {
       List<R> mappedItems = new ArrayList<>();
        for (T item : items) {
          mappedItems.add(map(item));
       }
        return mappedItems;
    }

}
