package com.yan.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSessionFactory {
	private MybatisSessionFactory() {
	}

	private static SqlSessionFactory factory;
	private static final ThreadLocal<SqlSession> ts = new ThreadLocal<>();
	static {
		try {
			buildFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> T getMapper(Class<T> clz) {
		SqlSession ss = getSqlSession();
		if (ss != null)
			return ss.getMapper(clz);
		return null;
	}

	public static void commitTransaction() {
		SqlSession ss = ts.get();
		if (ss != null)
			ss.commit();
	}

	public static void rollbackTransaction() {
		SqlSession ss = ts.get();
		if (ss != null)
			ss.rollback();
	}

	public static SqlSession getSqlSession() {
		SqlSession ss = ts.get();
		if (ss == null) {// 当前正在执行的线程没有存放过SqlSession则需要新建一个SqlSession，同时为了保证下次能获取到则需要存放
			ss = factory != null ? factory.openSession() : null;
			ts.set(ss);
		}
		return ss;
	}

	public static void closeSqlSession() {
		SqlSession ss = ts.get();
		ts.set(null);
		if (ss != null)
			ss.close();
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}

	private static void buildFactory() throws Exception {
		if (factory == null) {
			InputStream is = Resources
					.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		}
	}
}
