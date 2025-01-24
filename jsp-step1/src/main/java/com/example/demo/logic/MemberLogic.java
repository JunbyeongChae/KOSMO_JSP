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
    @Autowired
    private MemberDao memberDao = null;
    public Map<String,Object> login(Map<String, Object> pMap){
        log.info("MemberLogic login호출");
        Map<String,Object> rmap = null;
        rmap = memberDao.login(pMap);
        return rmap;
    }//end of login
    //회원 목록 조회를 활용하는 여러가지 경우의 수
    //1. 이메일 중복검사와 닉네임 중복검사 - type=overlap - 중복이 되니?- 존재하니? list.size():int
    //return값이 1이면 존재한다. ->  이메일 또는 닉네임 사용 불가, 0이면 없다. -> 이메일 또는 닉네임 사용이 가능하다.
    //2. type이 auth인경우 - 소셜로그인시 회원가입 유도 처리
    //3. 이메일 찾기 추가 : type=email
    //4. 이것도 저것도 아닌 경우
    public Object  memberList(Map<String,Object> pMap){
        log.info("memberList");
        //요청(중복검사, 회원조회)에 따라서 응답 객체가 달라져야 한다.
        //아래 Map은 조회결과를 담는 클래스 이므로 직접 인스턴스화를 함.
        //type이 auth이면서 list.size!=0
        Map<String,Object> rmap = new HashMap<>();
        List<Map<String,Object>> list = null; 
        list = memberDao.memberList(pMap);
        log.info("list.size() : " + list.size());//
        Object obj = null;
        //파라미터로 받아온 키 중에서 type이 존재하니?
        //type이 overlap이면 중복검사 - 이메일중복검사, 닉네임중복검사 : int
        if(pMap.containsKey("type")){
            if("overlap".equals(pMap.get("type"))){//중복검사일 때
                obj = list.size();
            }else if(("auth".equals(pMap.get("type").toString())) && (list.size()!=0)){//타입이 auth일 때 - 소셜로그인 한 거지 - 강제 회원가입
                rmap.put("MEM_UID", list.get(0).get("MEM_UID"));
                rmap.put("MEM_EMAIL", list.get(0).get("MEM_EMAIL"));
                rmap.put("MEM_AUTH", list.get(0).get("MEM_AUTH"));
                rmap.put("MEM_STATUS", list.get(0).get("MEM_STATUS"));
                rmap.put("MEM_NICKNAME", list.get(0).get("MEM_NICKNAME"));
                rmap.put("MEM_NO", list.get(0).get("MEM_NO"));
                obj = rmap;
            }else if(("email".equals(pMap.get("type"))) && (list.size()!=0)){//이메일 찾기 지원
                for(int i=0;i<list.size();i++){
                    rmap.put("MEM_EMAIL - " +i, list.get(i).get("MEM_EMAIL"));
                }
                obj = rmap;
            }else{
                obj = list;
            }
        }//end of 키에 type이 존재할 때
        //일반 회원 목록 조회일 때만 해당됨. - type이 없다.
        else{
            obj = list;
        }
        return obj;
    }//end of memberList
}//end of MemberLogic
