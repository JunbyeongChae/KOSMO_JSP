package com.example.demo.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MemberLogic {
  //로그인
  @Autowired
  private MemberDao memberDao = null;
  public Map<String, Object> login(Map<String, Object> pMap) {
    log.info("login call");
    Map<String, Object> rmap = null;
    rmap = memberDao.login(pMap);
    return rmap;
  }//////////////////////end of login
  //회원 조회를 활용하는 여러가지 경우의 수
  //1. 이메일중복검사/닉네임중복검사 - type=overlap
  //2. type이 auth인경우 - 소셜로그인시 회원가입 유도처리
  //3. 이메일 찾기 추가 - type=email
  //4. 그 외
  public Object memberList(Map<String, Object> pMap) {
    log.info("memberList call");
    //요청에 따라 응답객체가 달라야 한다
    //아래 Map은 조회 결과를 감는 클래스이므로 직접인스턴스화
    //type이 auth이면서 list.size!=0
    Map<String, Object> rmap = new HashMap<>();
    List<Map<String, Object>> list = null;
    list = memberDao.memberList(pMap);
    Object obj = null;
    //파라미커로 가져온 key중에 type이 있는가

    String type = (String) pMap.get("type");
    if (pMap.containsKey(type)) {
      if("overlap".equals(pMap.get("type"))){
        obj = list.size();
      }else if ("auth".equals(pMap.get("type").toString()) && list.size()!=0){
        rmap.put("MEM_EMAIL", pMap.get("MEM_EMAIL"));
        rmap.put("MEM_UID", pMap.get("MEM_UID"));
        rmap.put("MEM_AUTH", pMap.get("MEM_AUTH"));
        rmap.put("MEM_STATUS", pMap.get("MEM_STATUS"));
        rmap.put("MEM_NICKNAME", pMap.get("MEM_NICKNAME"));
        rmap.put("MEM_NO", pMap.get("MEM_NO"));
        obj = rmap;
      }else if ("email".equals(pMap.get("type")) && list.size()!=0){
        for(int i=0; i<list.size(); i++){
          rmap.put("MEM_EMAIL-"+i, list.get(i).get("MEM_EMAIL"));
        }
        obj = rmap;
      }else{
        obj = list;      
      }
    }else{//일반회원 목록조회일때 - type이 없다
      obj = list;      
    }
    return obj;
  }
}
