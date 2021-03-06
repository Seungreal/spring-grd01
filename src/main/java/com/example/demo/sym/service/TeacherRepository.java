package com.example.demo.sym.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cmm.util.Box;
import com.example.demo.sts.service.GradeVo;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}