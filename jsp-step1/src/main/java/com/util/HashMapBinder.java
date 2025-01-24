package com.util;

import java.util.Enumeration;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashMapBinder {
    HttpServletRequest req = null;
    public HashMapBinder(){}
    public HashMapBinder(HttpServletRequest req){
        this.req = req;
    }
    //get방식 요청시 사용자 입력한 값 Map에 담기
    public void bind(Map<String,Object> pmap){
        //필요한 쪽에서 Map을 생성하여 보내는 것이므로 초기화 처리하기
        pmap.clear();
        Enumeration<String> en = req.getParameterNames();
        while(en.hasMoreElements()){
            String key = en.nextElement();
            pmap.put(key, req.getParameter(key));
        }
    }
    //post방식 요청시 사용자 입력한 값 Map에 담기
    public void bindPost(Map<String,Object> pmap){
        //필요한 쪽에서 Map을 생성하여 보내는 것이므로 초기화 처리하기
        pmap.clear();
        Enumeration<String> en = req.getParameterNames();
        while(en.hasMoreElements()){
            String key = en.nextElement();
            pmap.put(key, HangulConversion.toUTF(req.getParameter(key)));
        }
    }    
}
