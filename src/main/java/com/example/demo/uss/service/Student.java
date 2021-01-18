package com.example.demo.uss.service;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stu_num") private int stuNum;
    @Column(name = "userid") private String userid;
    @Column(name = "password") private String password;
    @Column(name = "name") private String name;
    @Column(name = "birthday") private String birthday;
    @Column(name = "gender") private String gender;
    @Column(name = "regDate") private String regDate;
    @Column(name = "profile_img") private String profileImg;
    @Column(name = "mgr_num") private int mgrNum;

    @Builder
    private Student(String userid, String password, String name, String birthday, String gender, String regDate,String profileImg,int mgrNum){
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.regDate = regDate;
        this.profileImg = profileImg;
        this.mgrNum = mgrNum;
    }
}