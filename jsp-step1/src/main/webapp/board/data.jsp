<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList, java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%
    List<Map<String,Object>> list = new ArrayList<>();
    Map<String,Object> rmap = new HashMap<>();
    rmap.put("b_no",1);
    rmap.put("b_title","글제목1");
    rmap.put("b_writer","이순신");
    list.add(rmap);
    rmap = new HashMap<>();
    rmap.put("b_no",2);
    rmap.put("b_title","글제목2");
    rmap.put("b_writer","김유신");
    list.add(rmap);
    rmap = new HashMap<>();
    rmap.put("b_no",3);
    rmap.put("b_title","글제목3");
    rmap.put("b_writer","강감찬");
    list.add(rmap);
    Gson g = new Gson();
    String temp = g.toJson(list);
    out.print(temp);
%>