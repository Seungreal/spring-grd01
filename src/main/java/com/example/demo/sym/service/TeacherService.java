  
package com.example.demo.sym.service;

import static com.example.demo.cmm.util.Util.integer;
import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.util.Box;
import com.example.demo.cmm.util.DummyGenerator;
import com.example.demo.cmm.util.Pagination;
import com.example.demo.sts.service.GradeVo;
import com.example.demo.sts.service.SubjectRepository;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired SubjectRepository subjectRepository;
    @Autowired DummyGenerator dummy;
    @Autowired Box<Object> bx;

    public Teacher register(Teacher t) {
        return teacherRepository.save(t);
    }

    public void insertMany(int count) {
        List<String> l = asList("Java","Spring","Python","jQuery","eGovframe");
        Teacher t = null;
        for(int i=0;i<count;i++) {
            t=dummy.makeTeacher();
            teacherRepository.save(t);
        }
    }

    public List<?> list() {
        return teacherRepository.findAll();
    }


    public void delete(Teacher t) {
        teacherRepository.delete(t);
    }

    public List<GradeVo> paging(List<GradeVo> list, Pagination page) {
        return list.stream()
                .sorted(comparing(GradeVo::getStuNum))
                .skip(page.getStartRow()-1)
                .limit(page.getPageSize())
                .collect(toList());
    }
    /*public Map<?,?> selectAllBySubject(Box<?> bx){
        List<GradeVo> list = teacherRepository.selectJoinAll(bx.get());
        IntSummaryStatistics is = list.stream().collect(summarizingInt(GradeVo::getScore));
        var map = new HashMap<>();
        map.put("is",is);
        map.put("subjects",subjectRepository.selectAllSubject().stream().collect(joining(",")));
        Optional<GradeVo> highscoreGrade = list.stream().collect(reducing((g1,g2)-> g1.getScore() > g2.getScore() ? g1 :g2));
        System.out.println(highscoreGrade);
        var page = new Pagination("",
                integer.apply(bx.get("pageSize").toString()),
                integer.apply(bx.get("pageNum").toString()),
                list.size());
        map.put("list",list.stream().skip(page.getStartRow()).limit(page.getPageSize()).collect(toList()));
        map.put("page", page);

        return map;
    }*/

}