<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.*" %>
<%
  Map<String, Object> row = new HashMap<>();
  
  row.put("b_no", 1);
  row.put("b_title", "첫 번째 게시문");
  row.put("b_writer", "이순신");
  row.put("b_content", "첫 번째 게시문의 내용");
  List<Map<String, Object>> cList = new ArrayList<>();
  
  Map<String, Object> rmap = new HashMap<>();
  rmap = new HashMap<>();
  rmap.put("bc_no", 1);
  rmap.put("bc_comment", "첫 번째 댓글");
  rmap.put("bc_date","2025-01-01");
  cList.add(rmap);

  rmap = new HashMap<>();
  rmap.put("bc_no", 2);
  rmap.put("bc_comment", "두 번째 댓글");
  rmap.put("bc_date","2025-01-02");
  cList.add(rmap);

  rmap = new HashMap<>();
  rmap.put("bc_no", 3);
  rmap.put("bc_comment", "세 번째 댓글");
  rmap.put("bc_date","2025-01-03");
  cList.add(rmap);
  
  Map<String, Object> group = new HashMap<>();
  group.put("row",row);
  group.put("comments",cList);


  Gson g = new Gson();
  String temp = g.toJson(group);
  out.print(temp);

%>