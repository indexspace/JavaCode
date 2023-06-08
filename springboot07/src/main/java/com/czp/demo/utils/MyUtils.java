package com.czp.demo.utils;

import java.util.List;

public class MyUtils {
    public String listToString(List list){
        StringBuilder result = new StringBuilder();
        for (Object o : list) {
            result.append(o.toString()).append("\n");
        }
        return result.toString();
    }
}
