package com.util;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyBatisCommonFactory {
	public SqlSessionFactory sqlSessionFactory = null;
	public void init() {
		try {
			String resource = "com\\mybatis\\MyBatisConfig.xml";
			System.out.println("resource");
			Reader reader = Resources.getResourceAsReader(resource);
			log.info("before sqlSessionFactory : "+sqlSessionFactory);
			if(sqlSessionFactory == null) {

				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
			}
			log.info("after sqlSessionFactory : "+sqlSessionFactory);
			System.out.println("after sqlSessionFactory : "+sqlSessionFactory);
		} catch (Exception e) {
			log.info("[[ Exception ]] "+e.toString());
			System.out.println("[[ Exception ]] "+e.toString());
		}
	}// end of init
	public SqlSessionFactory getSqlSessionFactory() {
		System.out.println("11");
		init();
		return sqlSessionFactory;
	}
	public static void main(String[] args) {
		System.out.println("test");
		MyBatisCommonFactory mcf = new MyBatisCommonFactory();
		SqlSessionFactory sqlSessionFactory =mcf.getSqlSessionFactory();
		System.out.println(sqlSessionFactory);
	}
}
