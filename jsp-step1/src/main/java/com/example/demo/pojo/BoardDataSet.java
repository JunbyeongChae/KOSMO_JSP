package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDataSet {
  List<Map<String, Object>> detailList = new ArrayList<>();
  //글상세보기 가져오기-본문
  public void detailList() {
    Map<String, Object> row = new HashMap<>();
    row.put("b_title", "Title1");
    row.put("b_content", "Content1");
    row.put("b_hit", 0);
    detailList.add(row);
  }

  //해당 글에 대한 댓글 가져오기-댓글
  public void comListList() {
    Map<String, Object> comment = new HashMap<>();
    List<Map<String, Object>> comList = new ArrayList<>();
    Map<String, Object> row = new HashMap<>();
    row.put("bc_comList", "comList1");
    row.put("bc_date", "2021-01-01");
    row.put("email", "email1");
    comList.add(row);
    row = new HashMap<>();
    row.put("bc_comList", "comList2");
    row.put("bc_date", "2021-01-02");
    row.put("email", "email2");
    comList.add(row);
    comment.put("comment", comList);
    detailList.add(comment);
  }
  public static void main(String[] args) {
    BoardDataSet bset = new BoardDataSet();
    bset.detailList();
    System.out.println(bset.detailList);
  }
}
