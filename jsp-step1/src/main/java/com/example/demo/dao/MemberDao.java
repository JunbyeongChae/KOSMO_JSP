package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class MemberDao {
    //스프링에서는 절대로 인스턴스화를 직접 하지 않습니다.
    //직접 인스턴스화를 하는 것은 결합도 높다 라는 의미
    //인스턴스화를 직접 한다는 것은 스프링을 사용하지 않는 것이다.
    //스프링에서는 빈을 직접 관리해줌.-  BeanFactory, ApplicationContext
    //객체관리에 대한 책임이 개발자에서 프레임워크로 이관되었다.
    //spring-core.jar - 엔진
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;
    //이메일 비번 로그인 처리할 때
    //로그인 성공하면 - MEM_UID, MEM_EMAIL, MEM_NICKNAME, MEM_STATUS, MEM_AUTH, MEM_NO
    //쿠키, 세션, localStorage관리되어야 할 정보들이다.
    //react에서 로그인 버튼을 눌렀을 때 - GET, POST
    //로그인 성공시 반환할 값은 그 사람의 이름, 닉네임, 번호, 상태, 인증, 이메일, uid
    //한 사람(한건)에 대해서 여러가지 종류 값이 필요하므로 리턴 타입은 Map으로 결정하였다.
    public Map<String, Object> login(Map<String, Object> pMap){
        Map<String,Object> rmap = null;
        try {
            rmap = sqlSessionTemplate.selectOne("login", pMap);
            log.info(rmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rmap;
    }//end of login

    //회원 조회를 할 때
    //왜 리턴타입이 달라졌나? - 전체 회원 조회, 조건 검색일 때 n건일 수가 있다.
    public List<Map<String, Object>> memberList(Map<String, Object> pMap){
        List<Map<String,Object>> list = null;
        try {
            list = sqlSessionTemplate.selectList("memberList", pMap);
            log.info(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }//end of login

    public int memberInsert(Map<String, Object> pMap) {
        log.info("memberInsert");
        int result = -1;
        try {
            result = sqlSessionTemplate.insert("memberInsert", pMap);
            log.info(result);//0이면 입력 실패, 1이면 입력 성공
        } catch (Exception e) {
           e.printStackTrace();
        }
        return result;
    }
}
