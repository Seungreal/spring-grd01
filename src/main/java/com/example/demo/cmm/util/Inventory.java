package com.example.demo.cmm.util;
/*
 * 리스트 형식의 추상화
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("ls") @Lazy
public class Inventory<T> {
	private List<T> inventory;
	public Inventory() {inventory = new ArrayList<T>();}
	public void add(T t) {inventory.add(t);}
	public T get(int i) {return inventory.get(i);}
	public List<T> get(){return inventory;}
	public void clear() {inventory.clear();}
	public int size() {return inventory.size();}
}
