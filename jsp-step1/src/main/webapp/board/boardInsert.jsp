<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String b_title = request.getParameter("b_title");
    String b_writer = request.getParameter("b_writer");
    String b_content = request.getParameter("b_content");
    String b_date = request.getParameter("b_date");
    String b_email = request.getParameter("b_email");
    out.print(b_title+", "+b_writer+","+b_content+", "+b_date+", "+b_email);
%>