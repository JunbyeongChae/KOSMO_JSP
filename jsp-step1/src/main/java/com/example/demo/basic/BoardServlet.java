package com.example.demo.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Map<String, Object>> detailList = new ArrayList<>();
    //글상세보기 가져오기-본문
      Map<String, Object> row = new HashMap<>();
      row.put("b_title", "Title1");
      row.put("b_content", "Content1");
      row.put("b_hit", 0);
      detailList.add(row);
      System.out.println(detailList.toString());
  }
}
