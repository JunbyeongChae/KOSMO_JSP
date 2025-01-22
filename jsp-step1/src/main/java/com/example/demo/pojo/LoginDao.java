package com.example.demo.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginDao {
  public Map<String, Object> login(Map<String, Object> pmap) {
    MyBatisCommonFactory mcf = new MyBatisCommonFactory();
    log.info("login call");
    SqlSessionFactory sqlSessionFactory =mcf.getSqlSessionFactory();
    SqlSession sqlSession = null;
    Map<String, Object> rmap = null;

    try {
      sqlSession = sqlSessionFactory.openSession();
      List<Map<String, Object>> bList = sqlSession.selectList("login", pmap);
      log.info(bList);

      if (bList != null && bList.size() > 0) {
        rmap = bList.get(0);
      }else {
        rmap = new HashMap<>();
      }
    } catch (Exception e) {
      log.info(e.toString());
    }
    return rmap;
  }
}
