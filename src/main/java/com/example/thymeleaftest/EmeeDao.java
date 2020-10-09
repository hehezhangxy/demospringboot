package com.example.thymeleaftest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmeeDao {
    private static Map<Integer, Emee> emees = null;
    @Autowired
    private DepartDao departDao;
    static {
        emees = new HashMap<Integer, Emee>();
        emees.put(1000, new Emee(1000,"aa","eeee@ee",1,new Depart(100,"jiao"), new Date()));
    }
    private static Integer initid = 1007;

    public void save(Emee emee) {
        if (emee.getId() == null) {
            emee.setId(initid ++);
        }
        emee.setDepart(departDao.getDepartById(emee.getDepart().getId()));
        emees.put(emee.getId(), emee);
    }
    public Collection<Emee> getAll() {
        return emees.values();
    }
    public Emee getEmeeById(Integer id) {
        return emees.get(id);
    }
    public void delete(Integer id) {
        emees.remove(id);
    }
}
