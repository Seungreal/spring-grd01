package com.example.demo.cop.bbs.service;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="replies")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rep_num") private int repNum;
    @Column(name = "content") private String content;
    @Column(name = "art_num") private int artNum;

    @Builder
    private Reply(String content,int artNum){
        this.content = content;this.artNum=artNum;
    }
}