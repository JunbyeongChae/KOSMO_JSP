package com.example.demo.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import com.util.MyBatisCommonFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardDao {
  MyBatisCommonFactory mcf = new MyBatisCommonFactory();
  public List<Map<String, Object>> boardList() {
    List<Map<String, Object>> bList = null;
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();
    SqlSession sqlSession = null;
    try{
      sqlSession = sqlSessionFactory.openSession();
      Map<String, Object> pMap = new HashMap<>();
      pMap.put("cb_search", "b_title");
      pMap.put("keyword", "컨퍼런스");
      bList = sqlSession.selectList("boardList", pMap);
      log.info(bList);
    }catch(Exception e){
      log.info("[[ Exception ]] "+e.toString());
    }
    return bList;
  }
  
  public List<Map<String, Object>> boardList(Map<String,Object> pmap) {
    List<Map<String, Object>> bList = null;
    SqlSessionFactory sqlSessionFactory = mcf.getSqlSessionFactory();
    SqlSession sqlSession = null;
    try{
      sqlSession = sqlSessionFactory.openSession();
      Map<String, Object> pMap = new HashMap<>();
      pMap.put("cb_search", "b_title");
      pMap.put("keyword", "컨퍼런스");
      bList = sqlSession.selectList("boardList", pMap);
      log.info(bList);
    }catch(Exception e){
      log.info("[[ Exception ]] "+e.toString());
    }
    return bList;
  }
}
