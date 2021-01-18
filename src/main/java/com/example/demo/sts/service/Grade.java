package com.example.demo.sts.service;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grd_num") private int grdNum;
    @Column(name = "score") private int score;
    @Column(name = "grade") private String grade;
    @Column(name = "examDate") private String examDate;
    @Column(name = "passExam") private String passExam;
    @Column(name = "stu_num") private int stuNum;
    @Column(name = "sub_num") private int subNum;

    @Builder
    private Grade(int score, String grade, String examDate, String passExam,int stuNum,int subNum){
        this.score = score;
        this.grade = grade;
        this.examDate = examDate;
        this.passExam = passExam;
        this.stuNum = stuNum;
        this.subNum = subNum;
    }
}