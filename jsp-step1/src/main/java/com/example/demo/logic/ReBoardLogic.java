package com.example.demo.logic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ReBoardDao;

@Service
public class ReBoardLogic {
  @Autowired
  private ReBoardDao reBoardDao = null;
  public List<Map<String, Object>> boardList(){
    List<Map<String, Object>> bList = null;
    bList = reBoardDao.boardList();
    return bList;
  }
}
