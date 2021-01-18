package com.example.demo.sts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.util.DummyGenerator;
@Service
public class GradeService{
    @Autowired GradeRepository gradeRepository;
    @Autowired DummyGenerator dummy;
    public void insertMany(int count) {
        for(int i=1;i<=count;i++) {
            for(int j=1;j<=5;j++) {
                gradeRepository.save(dummy.makeGrade(i, j));
            }
        }
    }
    public List<GradeVo> selectAllforExam(String examDate){
        return null;
    }
}
