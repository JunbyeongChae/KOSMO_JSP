package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardDataSet {
    List<Map<String,Object>> detailList = new ArrayList<>();
    //글상세보기(한건) 가져오기 - 원글
    public void detailList(){
        Map<String, Object> row = new HashMap<>();
        row.put("b_title","글제목1");
        row.put("b_content","글제목1에 대한 내용1");
        row.put("b_hit", 15);
        detailList.add(row);
    }
    //해당(b_no) 글에 대한 댓글 가져오기 - 댓글 (한개, 0개, n개)
    public void commentList(){
        Map<String, Object> comment = new HashMap<>();
        List<Map<String,Object>> comList = new ArrayList<>();
        Map<String, Object> row = new HashMap<>();
        row.put("bc_comment","감사합니다.");
        row.put("bc_date","2025-01-03");
        row.put("email", "test@hot.com");
        comList.add(row);
        row = new HashMap<>();
        row.put("bc_comment","좋은 정보를 공유하셨습니다.");
        row.put("bc_date","2025-01-04");
        row.put("email", "kiwi@hot.com");
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
