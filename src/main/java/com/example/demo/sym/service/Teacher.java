package com.example.demo.sym.service;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tea_num") private int teaNum;
    @Column(name = "sub_num") private int subNum;
    @Column(name = "email") private String email;
    @Column(name = "password") private String password;
    @Column(name = "name") private String name;
    @Column(name = "profile_img") private String profileImg;

    @Builder
    private Teacher(int subNum, String email, String password, String name, String profileImg){
        this.subNum = subNum;
        this.email = email;
        this.password = password;
        this.name = name;
        this.profileImg = profileImg;
    }
}
