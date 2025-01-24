package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //서블릿 클래스를 인지하려면 반드시 추가할것.
public class JspStep1Application {

	public static void main(String[] args) {
		SpringApplication.run(JspStep1Application.class, args);
	}

}
