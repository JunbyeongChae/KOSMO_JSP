package com.example.demo.pojo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardController implements Controller{
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    String upmu[] = (String[]) req.getAttribute("upmu");
    //글 목록 조회
    if("boardList".equals(upmu[1])){
      
    }
    //글 등록
    else if("boardInsert".equals(upmu[1])){

    }
    //글 수정
    else if("boardUpdate".equals(upmu[1])){

    }
    //글 삭제
    else if("boardDelete".equals(upmu[1])){

    }
    //글 상세보기
    else if("boardDetail".equals(upmu[1])){

    }
    return null;
  }
}
