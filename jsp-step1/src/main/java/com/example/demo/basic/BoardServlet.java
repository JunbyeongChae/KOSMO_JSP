package com.example.demo.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
@Log4j2
@WebServlet("/test.ko")
public class BoardServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet호출"); 
        List<Map<String,Object>> detailList = new ArrayList<>();
    //글상세보기(한건) 가져오기 - 원글
        Map<String, Object> row = new HashMap<>();
        row.put("b_title","글제목1");
        row.put("b_content","글제목1에 대한 내용1");
        row.put("b_hit", 15);
        detailList.add(row);
        Gson g = new Gson();
        String temp = g.toJson(detailList);
        System.out.println(temp);
    }
}
