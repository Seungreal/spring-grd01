package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cmm.util.Box;
import com.example.demo.cmm.util.Pagination;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

}