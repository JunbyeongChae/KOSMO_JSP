package com.util;
//Tomcat서버경우 기본 인코딩 타입이 ISO-8859_1 -> euc-kr, utf-8
public class HangulConversion {
    //영어표준문자셋으로 받은 값을 강제로 euc-kr 컨버전해줌
    public static String toKor(String en){
        if(en == null) return null;
        try {
            return new String(en.getBytes("8859_1"), "euc-kr");
        } catch (Exception e) {
            return en;
        }
    }//end of toKor
    //
    public static String toUTF(String en){
        if(en == null) return null;
        try {
            return new String(en.getBytes("8859_1"), "utf-8");
        } catch (Exception e) {
            return en;
        }
    }//end of toUTF
}
