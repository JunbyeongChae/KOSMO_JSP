<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList, java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%
    Map<String,Object> row = new HashMap<>();
    row.put("b_no",2);
    row.put("b_title","글제목2");
    row.put("b_writer","김유신");
    List<Map<String,Object>> cList = new ArrayList<>();
    Map<String,Object> rmap = new HashMap<>();
    rmap.put("bc_no",1);
    rmap.put("bc_comment","댓글1");
    rmap.put("bc_date","2025-01-01");
    cList.add(rmap);
    rmap = new HashMap<>();
    rmap.put("bc_no",2);
    rmap.put("bc_comment","댓글2");
    rmap.put("bc_date","2025-01-02");
    cList.add(rmap);
    rmap = new HashMap<>();
    rmap.put("bc_no",3);
    rmap.put("bc_comment","댓글3");
    rmap.put("bc_date","2025-01-03");
    cList.add(rmap);
    Map<String, Object> group = new HashMap<>();
    group.put("row", row);
    group.put("comments", cList);
    Gson g = new Gson();
    String temp = g.toJson(group);
    out.print(temp);
%>