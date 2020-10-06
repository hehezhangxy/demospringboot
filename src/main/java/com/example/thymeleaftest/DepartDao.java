package com.example.thymeleaftest;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartDao {
    private static Map<Integer, Depart> departs = null;
    static {
        departs = new HashMap<Integer, Depart>();
        departs.put(100, new Depart(100,"jiao"));
        departs.put(101, new Depart(101,"shi"));
        departs.put(102, new Depart(102,"yan"));
        departs.put(103, new Depart(103,"yun"));
    }
    public Collection<Depart> getDeparts() {
        return departs.values();
    }
    public Depart getDepartById(Integer id) {
        return  departs.get(id);
    }
}
