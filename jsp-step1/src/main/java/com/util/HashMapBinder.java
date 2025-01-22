package com.util;

import java.util.Enumeration;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashMapBinder {
  HttpServletRequest req = null;
  public HashMapBinder() {}
  public HashMapBinder(HttpServletRequest req) {
    this.req = req;
  }

  //GET
  public void bind(Map<String, Object> pmap) {
    pmap.clear();
    Enumeration<String> en = req.getParameterNames();
    while (en.hasMoreElements()) {
      String key = en.nextElement();
      pmap.put(key, req.getParameter(key));
    }
  }
  //POST
  public void bindPost(Map<String, Object> pmap) {
    pmap.clear();
    Enumeration<String> en = req.getParameterNames();
    while (en.hasMoreElements()) {
      String key = en.nextElement();
      pmap.put(key, HangulConversion.toUTF(req.getParameter(key)));
    }
  }
}
