package com.example.demo.sym.web;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.sym.service.Manager;
import com.example.demo.sym.service.ManagerRepository;
import com.example.demo.sym.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    ManagerService managerService;
    @Autowired
    ManagerRepository managerRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping("/")
    public Messenger register(@RequestBody Manager m){
        logger.info("등록하려는 관리자정보:"+m.toString());
        managerService.register(m);
        return Messenger.SUCCESS;
    }

    @PostMapping("/access")
    public Optional<Manager> access(@RequestBody Manager m) {
        logger.info("로그인하려는 관리자정보:"+m.toString());
        return managerRepository.findById(0);
    }
}