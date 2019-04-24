package com.example.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

/*
 * SecurityConfig 클래스에 configure() 메소드를 이용해서 특정 경로에 접근을 제어하는 여러 설정을 했지만 단순 어노테이션만을 이용해서 접근을 제한할 수 있다.
 * 스프링 시큐리티는 @Secured 어노테이션을 제공하는데 속성 값으로 문자열의 배열이나 문자열을 이용해서 권한을 지정한다.
 * @Secured가 제대로 작동하기 위해서 SecurityConfig 클래스에 
 * 	- @EnableGlobalMethodSecurity 어노테이션을 추가하고
 *  - securedEnabled 속성 값을 true로 지정해야 한다. 
 * */
@Controller
@Log
public class SampleController {
	@GetMapping("/")
	public String index() {
		log.info("index");
		return "index";
	}
	
	@RequestMapping("/guest")
	public void forGuest() {
		log.info("guest");
	}
	
	@RequestMapping("/manager")
	public void forManager() {
		log.info("manager");
	}
	
	@RequestMapping("/admin")
	public void forAdmin() {
		log.info("admin");
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/adminSecret")
	public void forAdminSecret() {
		log.info("admin secret");
	}
	
	@Secured("ROLE_MANAGER")
	@RequestMapping("/managerSecret")
	public void forManagerSecret() {
		log.info("manager secret");
	}
}
