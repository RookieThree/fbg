package com.jiang.array;
/**
 * ����ʽ
 *	�ص㣺1������˽��
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
