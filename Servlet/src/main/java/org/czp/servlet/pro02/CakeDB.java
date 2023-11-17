package org.czp.servlet.pro02;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class CakeDB {
    private static final Map<String, Cake> cakes = new LinkedHashMap<String, Cake>();
    static {
        cakes.put("1", new Cake("1", "A类蛋糕"));
        cakes.put("2", new Cake("2", "B类蛋糕"));
        cakes.put("3", new Cake("3", "C类蛋糕"));
        cakes.put("4", new Cake("4", "D类蛋糕"));
        cakes.put("5", new Cake("5", "E类蛋糕"));
    }

    public static Collection<Cake> getAllCake() {
        return cakes.values();
    }

    public static Cake getCakeById(String id) {
        return cakes.get(id);
    }
}
