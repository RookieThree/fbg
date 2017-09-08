package com.jiang.array;
/**
 * 饿汉式
 *	特点：1、构造私有
 */
public class Singleton {
	private Singleton(){}
	private final static Singleton instance= new Singleton();
	public static Singleton getInstance(){
		return instance;
	}
	public void print(){
		System.out.println("hello");
	}
}
