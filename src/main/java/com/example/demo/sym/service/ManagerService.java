package com.example.demo.sym.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.util.DummyGenerator;

@Service
public class ManagerService {
    @Autowired ManagerRepository managerRepository;
    @Autowired DummyGenerator dummy;

    public Manager register(Manager m) {
        return managerRepository.save(m);
    }

    public List<?> insertMany(int count) {
        var list = new ArrayList<Manager>();
        Manager m = null;
        for(int i=0;i<count;i++) {
            m= dummy.makeManager();
            list.add(m);
        }
        List<?> r= managerRepository.saveAll(list);
        return r;
    }

}