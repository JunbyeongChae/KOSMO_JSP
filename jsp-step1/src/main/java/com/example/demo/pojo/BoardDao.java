package com.example.demo.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class BoardDao {
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
    public List<Map<String, Object>> boardList(Map<String,Object> pmap) {
        List<Map<String, Object>> bList = null;
        //물리적으로 떨어져 있는 서버에 커넥션을 맞는다.
        SqlSessionFactory sqlSessionFactory =mcf.getSqlSessionFactory();
        //연결이 되고  쿼리문을 요청할 때 필요한 메소드 제공함.
        //sqlSession.insert(), sqlSession.update(), sqlSession.delete()
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Map<String,Object> pMap = new HashMap<>();
            pMap.put("cb_search", "b_title");
            pMap.put("keyword", "컨퍼런스");
            log.info(pMap.get("cb_search"));//b_title, b_content, nickname
            log.info(pMap.get("keyword"));//컨퍼런스
            bList = sqlSession.selectList("boardList", pMap);
            log.info(bList);
        } catch (Exception e) {
            log.info(e.toString());
        }
        return bList;
    }
    
}
/*
 * 조회  결과에 null이 출력되는 경우
 * 1)db에서 조회한 결과에 대해 return시 null을 입력한 경우
 * 2)db테이블에 commit() 하지 않은 경우
 * 3)조건절에 들어오는 값이 존재하지 않는 값을 파라미터로 넘긴 경우
 * 
 */