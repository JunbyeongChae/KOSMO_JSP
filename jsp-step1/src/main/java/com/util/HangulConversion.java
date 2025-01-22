package com.util;

//Tomcat server : default incoding type ISO-8859-1 -> UTF-8||euc-kr
public class HangulConversion {
  //영어표준문자셋으로 받은 문자값을 강제로 euc-kr 컨버전
  public static String toKor(String en) {
    if(en == null) return null;
    try {
      return new String(en.getBytes("8859-1"), "euc-kr");
    } catch (Exception e) {
      return en;
    }
  }

  //UTF-8 컨버전
  public static String toUTF(String en) {
    if (en == null) return null;
    try {
      return new String(en.getBytes("8859-1"), "UTF-8");
    } catch (Exception e) {
      return en;
    }
  }
  
}
