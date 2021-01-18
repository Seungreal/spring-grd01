package com.example.demo.sts.web;

import com.example.demo.HomeController;
import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.util.Box;
import com.example.demo.sts.service.GradeRepository;
import com.example.demo.sts.service.GradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/grades")
public class GradeController<CommonRepository> {
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    GradeService gradeService;
    @Autowired
    Box<String> bx;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @GetMapping("/register")
    public int registerMany() {
        logger.info("grade register...");
        gradeService.insertMany(100);
        bx.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString()+ Table.GRADES);
        return (int)gradeRepository.count();
    }

}
