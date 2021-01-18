package com.example.demo.sts.service;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.enm.SubCate;
import com.example.demo.cmm.util.Box;
import com.example.demo.cmm.util.DummyGenerator;
import com.example.demo.cmm.util.Inventory;

@Service
public class SubjectService {
    @Autowired SubjectRepository subjectRepository;
    @Autowired DummyGenerator dummy;
    @Autowired Inventory<Subject> subIv;
    @Autowired Inventory<GradeVo> grdIv;
    public void insertMany(int count) {
        Subject g = null;
        var l1 = asList("Java","Spring","Python","jQuery","eGovframe");
        var l2 = asList("Java","Spring","Python","jQuery","eGovframe");
        for(int i=0;i<count;i++) {
            g= new Subject();
            subjectRepository.save(g);
        }
    }
    public List<GradeVo> groupBysubject(Box<String> bx){
        /*List<GradeVo> l = subjectRepository.groupBySubject(bx.get());
        System.out.println("그래이드 총 카운트: "+ l.size());

        Map<Integer, List<GradeVo>> m  = l.stream()
                .collect( groupingBy(GradeVo::getSubNum));

        List<GradeVo> l2 = m.get(Integer.parseInt(bx.get("subNum")));
        l2.forEach(System.out::println);*/
        return null;
    }
    public List<GradeVo> groupByGrade(Box<String> bx){
        /*List<GradeVo> l = subjectRepository
                .groupBySubject(bx.get());

        Map<Object, List<GradeVo>> m
                = l.stream().collect(
                groupingBy( gradeVo -> {
                    if(gradeVo.getScore() > 90) return SubCate.GRADE_A;
                    if(gradeVo.getScore() > 80) return SubCate.GRADE_B;
                    if(gradeVo.getScore() > 70) return SubCate.GRADE_C;
                    if(gradeVo.getScore() > 60) return SubCate.GRADE_D;
                    else return SubCate.GRADE_F;
                }));
        List<GradeVo> l2 = m.get(SubCate.GRADE_B);
        l2.forEach(System.out::println);*/
        return null;
    }
}
