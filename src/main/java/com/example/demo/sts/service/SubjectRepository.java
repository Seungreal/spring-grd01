package com.example.demo.sts.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cmm.util.Box;
import com.example.demo.cmm.util.Inventory;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

}
