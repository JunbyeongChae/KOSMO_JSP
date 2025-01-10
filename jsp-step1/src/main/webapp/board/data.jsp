<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.*" %>
<%
  List<Map<String, Object>> list = new ArrayList<>();
  Map<String, Object> rmap = new HashMap<>();
  
  rmap.put("b_no", 1);
  rmap.put("b_title", "첫 번째 게시문");
  rmap.put("b_writer", "이순신");
  rmap.put("b_content", "첫 번째 게시문의 내용");
  list.add(rmap);
  
  rmap = new HashMap<>();
  rmap.put("b_no", 2);
  rmap.put("b_title", "두 번째 게시문");
  rmap.put("b_writer", "김유신");
  rmap.put("b_content", "두 번째 게시문의 내용");
  list.add(rmap);
  
  rmap = new HashMap<>();
  rmap.put("b_no", 3);
  rmap.put("b_title", "세 번째 게시문");
  rmap.put("b_writer", "강감찬");
  rmap.put("b_content", "세 번째 게시문의 내용");
  list.add(rmap);

  Gson g = new Gson();
  String temp = g.toJson(list);
  out.print(temp);

%>