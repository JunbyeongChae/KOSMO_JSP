package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //모든 요청에 대해서 검토해줘
                      .allowedOrigins("http://localhost:3000", "http://localhost:8000")//허용할 오리진들
                      .allowedMethods("GET", "POST", "PUT", "DELETE") //허용할 HTTP 메소드
                      .allowedHeaders("*") //모든 헤더 허용 (오픈API마다 다른 기준으로 )
                      .allowCredentials(true) //쿠키 또는 인증 정보 포함 허용
                      .maxAge(3600); //1시간 동안 캐싱
    }
}
