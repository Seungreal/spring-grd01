package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.util.Box;
import com.example.demo.cmm.util.DummyGenerator;
import com.example.demo.cmm.util.Pagination;

@Service
public class StudentService{
    @Autowired DummyGenerator dummy;
    @Autowired
    StudentRepository studentRepository;
    @Autowired Box<String> bx;

    public void register(Student s) {
        studentRepository.save(s);
    }

    public void insertMany(int count) {
        for(int i=0;i<count;i++) {
            studentRepository.save(dummy.makeStudent());
        }
    }

    public void delete(Student s) {
        studentRepository.delete(s);
    }

    public void truncate() {
        bx.put("TRUNCATE_STUDENTS", Sql.TRUNCATE.toString()+"students");
        studentRepository.deleteAll();
    }
    public int count() {
        bx.put("COUNT_STUDENTS",Sql.TOTAL_COUNT.toString()+"students");
        return (int)studentRepository.count();
    }
    /*public List<Student> list(Pagination page){

        return studentRepository.findAll().stream()
                .sorted(comparing(Student::getStuNum).reversed())
                .skip(page.getStartRow()-1)
                .limit(page.getPageSize())
                .collect(toList());
    }
    /*public List<Student> selectByGender(String Gender){
    	return selectAll().stream()

    			.collect(toList());
    }*/
    /*public List<Student> listByBirthday(){
        return studentRepository.findAll().stream()
                .filter(x->(x.getBirthday().compareTo("1995"))>0)
                .sorted(comparing(Student::getStuNum).reversed())
                .collect(toList());
    }*/
}