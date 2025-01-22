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
  //스프링에서는 절대로 직접 인스턴스화를 하지 않음.
  //직접인스턴스화는 결합도가 높다라는 의미
  //인스턴스화를 직접 한다는 것은 스프링을 사용하지 않는다는 것
  //스프링에서는 빈을 직접 관리해줌 - BeanFactory, ApplicationContext
  //객체에 대한 책임이 개발자에서 프레임워크로 이관되었다
  //spring - core.jar - 엔진
  @Autowired
  private SqlSessionTemplate sqlSessionTemplate = null;
  //이메일 비번 로그인처리
  //로그인 성공하면 - MEM_UID,MEM_EMAIL,MEM_NICKNAME, MEM_STATUS, MEM_AUTH, MEM_NO
  //쿠키,세션,localstorage에 관리되어야 할 정보들
  //react에서 로그인버튼 클릭시 -GET,POST
  //로그인 성공시 반환할 값은 그 사람의 이름,닉네임,번호,상태,인증,이메일,uid
  //한 사람에 대해서 여러가지 종류값이 필요하므로 리턴타입은 Map으로 결정하였다.
  public Map<String, Object> login(Map<String, Object> pmap) {
    Map<String, Object> rmap = null;
    try {
      rmap = sqlSessionTemplate.selectOne("login", pmap);
      log.info(rmap);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rmap;
  }///////////////end of login

  //회원조회
  public List<Map<String, Object>> memberList(Map<String, Object> pmap) {
    List<Map<String, Object>> list = null;
    try {
      list = sqlSessionTemplate.selectList("memberList", pmap);
      log.info(list);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }//////////////end of memberList
}
