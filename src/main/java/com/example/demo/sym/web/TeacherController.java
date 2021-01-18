package com.example.demo.sym.web;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.util.Box;
import com.example.demo.sts.service.SubjectRepository;
import com.example.demo.sym.service.Teacher;
import com.example.demo.sym.service.TeacherRepository;
import com.example.demo.sym.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TeacherService teacherService;
    @Autowired
    Box<String> bx;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping("")
    public Messenger register(@RequestBody Teacher t){
        logger.info("강사 정보:"+t.toString());
        teacherService.register(t);
        return Messenger.SUCCESS;
    }
    @PostMapping("/access")
    public Optional<Teacher> access(@RequestBody Teacher t) {
        logger.info("강사 정보:"+t.toString());
        return teacherRepository.findById(0);
    }
    @GetMapping("")
    public List<?> list(){
        return teacherService.list();
    }


    @DeleteMapping("")
    public Messenger delete(@RequestBody Teacher t){
        teacherService.delete(t);
        return Messenger.SUCCESS;
    }
    /*@GetMapping("/page/{pageSize}/{pageNum}/subject/{subNum}/{examDate}")
    public Map<?,?> selectAllJoin(@PathVariable String examDate, @PathVariable String subNum,
                                  @PathVariable String pageSize, @PathVariable String pageNum){
        bx.put("examDate", examDate);
        bx.put("subNum", subNum);
        bx.put("pageSize", pageSize);
        bx.put("pageNum", pageNum);
        return teacherService.selectAllBySubJect(bx);
    }*/

}