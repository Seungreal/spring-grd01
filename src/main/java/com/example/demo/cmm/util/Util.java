package com.example.demo.cmm.util;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Util {
	public static void print(String s) {
		Consumer<String> c = System.out::println;
		c.accept(s);
	}
    public static Function<String,Integer> integer= Integer::valueOf;
    public static Function<Object,String> string = String::valueOf;
    public static BiPredicate<String,String> equals = String::equals;
    public static BiFunction<Integer,Integer,Integer> rangeRandom = (t,u)->(int)(Math.random()*(u-t))+t;
    public static Supplier<Integer> scoreRandom = ()->(int)(Math.random()*(100));
    public static Function<Integer,int[]> arr = int[]::new;
    public static Supplier<List<Object>> arrayList = ArrayList::new;
    public static Supplier<LocalDate> date = LocalDate::now;
    public static Supplier<LocalTime> time = LocalTime::now;
    public static BiFunction<String,String,File> mkdir = File::new;
    public static BiFunction<File,String,File> mkfile = File::new;
    
}