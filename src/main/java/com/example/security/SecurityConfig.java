package com.example.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.java.Log;

/*
 * 시큐리티에 대한 설정 클래스
 * 이 클래스가 정상적으로 인식되도록 @EnableWebSecurity 어노테이션을 추가하고 설정을 담당하는 WebSecurityConfigurerAdapter 클래스를 상속한다.
 * */
@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// [주의!] configure() 메소드를 오버라이드하는 경우에는 HttpSecurity 클래스 타입을 파라미터로 처리하는 메소드를 선택해야 한다.
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			log.info("security config...");
		}
}
