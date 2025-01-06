package com.example.demo.pojo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
  public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
