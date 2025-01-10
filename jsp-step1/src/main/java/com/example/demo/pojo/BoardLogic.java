package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardLogic {
  BoardDao boardDao = new BoardDao();

  public List<Map<String, Object>> boardList() {
    log.info("boardList");
    List<Map<String, Object>> list = new ArrayList<>();
    list = boardDao.boardList();
    log.info(list);
    return list;
  }

  // 글 상세보기
  public List<Map<String, Object>> boardDetail(Map<String, Object> pmap) {
    List<Map<String, Object>> list = new ArrayList<>();
    list = boardDao.boardList(pmap);
    return list;
  }
  
  // 글등록
  public int boardInsert() {
    throw new UnsupportedOperationException("Unimplemented method 'boardInsert'");
  }

  // 글 수정
  public int boardUpdate() {
    throw new UnsupportedOperationException("Unimplemented method 'boardUpdate'");
  }

  // 글 삭제
  public int boardDelete() {
    throw new UnsupportedOperationException("Unimplemented method 'boardDelete'");
  }

}
