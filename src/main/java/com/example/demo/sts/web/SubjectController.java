package com.example.demo.sts.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.util.Box;
import com.example.demo.sts.service.SubjectRepository;
import com.example.demo.sts.service.SubjectService;
import com.example.demo.sym.service.TeacherRepository;

@RestController("/subjects")
public class SubjectController {
    @Autowired SubjectService subjectService;
    @Autowired SubjectRepository subjectRepository;
    @Autowired TeacherRepository teacherRepository;
    @Autowired Box<String> bx;
    @PostMapping("")
    public Messenger register() {
        return Messenger.SUCCESS;
    }
    @GetMapping("/groupby/{examDate}/{subNum}")
    public Map<?,?> totalScoreGroupBySubject(@PathVariable String examDate,@PathVariable String subNum) {
        bx.put("examDate", examDate);
        bx.put("subNum", subNum);
        subjectService.groupBysubject(bx);
        return null;
    }
}
