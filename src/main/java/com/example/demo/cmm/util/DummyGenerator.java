package com.example.demo.cmm.util;

import static com.example.demo.cmm.util.Util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.sts.service.Grade;
import com.example.demo.sym.service.Manager;
import com.example.demo.sym.service.Teacher;
import com.example.demo.uss.service.Student;
import org.springframework.stereotype.Component;

import com.example.demo.cmm.enm.Path;

@Component("dummy")
public class DummyGenerator {
	/*******************************
	 * Student Dummy Date Generator
	 *******************************/
	/*1970~2000 연도*/
	public int makeYear(int from,int to) {
		return rangeRandom.apply(from,to);
	}
	/*1~12 월*/
	public int makeMonth() {
		return rangeRandom.apply(1,13);
	}
	public int makeDay(int from,int to) {
		return rangeRandom.apply(from,to);
	}
	/*2월 28일,29일(윤년)
	 * 1,3,5,7,8,10,12월 31일
	 * 4,6,9,11 30일*/
	public String makeBirthday() {
		int year = makeYear(1970,2000);
		int month = makeMonth();
		int date=0;
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			date=makeDay(1,31);
		case 4: case 6: case 9: case 11:
			date=makeDay(1,30);
		case 2:
			date=year%400==0||year%4==0&&year%100!=0 ? makeDay(1,29) : makeDay(1,28);
		}
		return year+"-"+month+"-"+date;
	}
	public String makeRegdate() {
		int year = makeYear(2019,2020);
		int month = makeMonth();
		int date=0;
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			date=makeDay(1,31);
		case 4: case 6: case 9: case 11:
			date=makeDay(1,30);
		case 2:
			date=year%400==0||year%4==0&&year%100!=0 ? makeDay(1,29) : makeDay(1,28);
		}
		return year+"-"+month+"-"+date;
	}
	/*랜덤 성별 생성*/
	public String makeGender() {
		List<String> l = asList("F","M");
		Collections.shuffle(l);
		return l.get(0);
	}
	/*랜덤 id 생성*/
	public String makeUserid() {
		List<String> al = Stream.of("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz")
				.map(word->word.split(""))
				.flatMap(Arrays::stream)
				.collect(toList());
		Collections.shuffle(al);
		return al.stream().limit(5).collect(Collectors.joining());
	}
	/*랜덤 번호 생성*/
	public String makePhoneNumber() {
		return "010-"+rangeRandom.apply(0,10000)+"-"+rangeRandom.apply(0,10000);
	}
	/*랜덤 이름 생성*/
	public String makeUsername() {
		List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
		        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
		        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
		        "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
		        "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
		List<String> name = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
		        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
		        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
		        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
		        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
		        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
		        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
		        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
		        "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
		        "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
		Collections.shuffle(fname);
		Collections.shuffle(name);
		/*List<String> fullname = fname.stream()
										.flatMap(i->name.stream().flatMap(j->name.stream().map(k->i+j+k)))
										.collect(toList());*/
		return fname.get(0)+name.get(0)+name.get(1);
	}
	public String makeSubject() {
		List<String> sl = asList("Java","Spring","Python","jQuery","eGovframe");
		Collections.shuffle(sl);
		return sl.get(0);
	}
	public int makeSubNum() {
		List<Integer> sl = asList(1,2,3,4,5);
		Collections.shuffle(sl);
		return sl.get(0);
	}
	
	public String makeEmail() {
		List<String> ls = Arrays.asList("@test.com","@gmail.com","@naver.com");
		Collections.shuffle(ls);
		return makeUserid()+ls.get(0);
	}
	public Manager makeManager() {
		return null;//new Manager("",makeEmail(),"1",makeUsername(),Path.DEFAULT_PROFILE.toString());
	}
	
	public Teacher makeTeacher() {
		return null;//new Teacher(0,makeSubNum(),makeUsername(),"1"
				//,makeEmail(),Path.DEFAULT_PROFILE.toString());
	}
	public Student makeStudent() {
		return null;//new Student(0,1,makeUserid(),"1",makeUsername(),makeBirthday(),makeGender()
				//,makeRegdate(),Path.DEFAULT_PROFILE.toString());
	}
	/*******************************
	 * Grade Dummy Date Generator
	 *******************************/
	public List<Integer> makeScore(){
		return Stream.generate(()->(int)(Math.random()*(100)))
				.limit(100)
				.collect(toList());
	}
	public String makeExamdate() {
		return "2020-11-30";
	}
	public Grade makeGrade(int stuNum, int subNum) {
		return null;//new Grade(0,stuNum,subNum,makeScore().get(0),makeExamdate());
	}
}
