package com.example.demo.cmm.enm;

public enum Sql {
	CREATE_MANAGERS,CREATE_SUBJECTS,CREATE_STUDENTS,CREATE_TEACERS,
	CREATE_GRADES,CREATE_ARTICLES,CREATE_REPLIES,
	TRUNCATE,TOTAL_COUNT,DROP_TABLE,TABLE_COUNT;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case CREATE_MANAGERS:
			query="create table managers(mgr_num int primary key auto_increment,"
					+ "email varchar(20),"
					+ "password varchar(20),"
					+ "name varchar(20),"
					+ "profile_img text)";break;
		case CREATE_SUBJECTS:
			query="create table subjects(sub_num int primary key auto_increment, "
					+ "subject varchar(20),"
					+ "description varchar(100))";break;
		case CREATE_STUDENTS:
			query="create table students(stu_num int primary key auto_increment, "
					+ "userid varchar(20), "
					+ "password varchar(20), "
					+ "name varchar(20), "
					+ "birthday varchar(20), "
					+ "gender varchar(20), "
					+ "reg_date varchar(20), "
					+ "profile_img text,"
					+ "mgr_num int, "
					+ "constraint mgr_stu_fk foreign key(mgr_num) references managers(mgr_num))";break;
		case CREATE_TEACERS:
			query="create table teachers(tea_num int primary key auto_increment,"
					+ "name varchar(20),"
					+ "password varchar(20),"
					+ "email varchar(20),"
					+ "profile_img text,"
					+ "sub_num int,"
					+ "constraint sub_tea_fk foreign key(sub_num) references subjects(sub_num))";break;
		case CREATE_GRADES:
			query="create table grades(grd_num int primary key auto_increment,"
					+ "score int, "
					+ "grade varchar(20) default '미정', "
					+ "exam_date varchar(20), "
					+ "pass_exam varchar(20),"
					+ "stu_num int,"
					+ "sub_num int,"
					+ "constraint stu_grd_fk foreign key(stu_num) references students(stu_num),"
					+ "constraint sub_grd_fk foreign key(sub_num) references subjects(sub_num))";break;
		case CREATE_ARTICLES:
			query="create table articles(art_num int primary key auto_increment,"
					+ "title varchar(20),"
					+ "content text,"
					+ "count varchar(20),"
					+ "reg_date varchar(20),"
					+ "mgr_num int,"
					+ "tea_num int,"
					+ "stu_num int,"
					+ "constraint mgr_art_fk foreign key(mgr_num) references managers(mgr_num),"
					+ "constraint tea_art_fk foreign key(tea_num) references teachers(tea_num),"
					+ "constraint stu_art_fk foreign key(stu_num) references students(stu_num))";break;
		case CREATE_REPLIES:
			query="create table replies(reply_num int primary key auto_increment,"
					+ "content varchar(100),"
					+ "reg_date varchar(20),"
					+ "art_num int,"
					+ "mgr_num int,"
					+ "tea_num int,"
					+ "stu_num int,"
					+ "constraint art_rep_fk foreign key(art_num) references articles(art_num),"
					+ "constraint mgr_rep_fk foreign key(mgr_num) references managers(mgr_num),"
					+ "constraint tea_rep_fk foreign key(tea_num) references teachers(tea_num),"
					+ "constraint stu_rep_fk foreign key(stu_num) references students(stu_num))";break;
		case TRUNCATE:
			query="truncate table \t";break;
		case TOTAL_COUNT:
			query="select count(*) as count from \t";break;
		case DROP_TABLE:
			query = "drop table if exists \t"; break;
		case TABLE_COUNT:
			query = "select count(*) from information_schema.tables where table_schema = 'mariadb'";break;
		}
		return query;
	}
}
