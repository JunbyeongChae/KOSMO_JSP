<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String b_title = request.getParameter("title1");
  String b_writer = request.getParameter("writer1");
  String b_content = request.getParameter("content1");
  String b_date = request.getParameter("date");
  String b_email = request.getParameter("email");
  out.print(b_title);
  out.print(b_writer);
  out.print(b_content);
  out.print(b_date);
  out.print(b_email);
%>