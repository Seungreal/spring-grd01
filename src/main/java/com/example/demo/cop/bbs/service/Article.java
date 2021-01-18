package com.example.demo.cop.bbs.service;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "art_num") private int artNum;
    @Column(name = "title") private String title;
    @Column(name = "content") private String content;
    @Column(name = "count") private String count;
    @Column(name = "writer_num") private int writerNum;

    @Builder
    private Article(String title, String content,String count,int writerNum){
        this.title = title;
        this.content = content;
        this.count = count;
        this.writerNum = writerNum;
    }
}