package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

/*
 * 2) 기존에 작성된 Repository나 서비스 객체들을 이용해서 별도로 시큐리티 관련 서비스를 개발하는 방법(사용자 정의)
 * 모든 인증 매니저는 결과적으로 UserDetails 타입의 객체를 반환하도록 구현된다.
 * 만약 인증 매니저를 커스터마이징하려면 새로운 클래스를 정의해 UserDetailsService 인터페이스를 구현하고 이를 HttpSecurity 객체가 사용할 수 있도록 지정하면 된다.
 * */
@Service // @Service 어노테이션을 추가했으므로 스프링에서 빈으로 처리한다(SecurityConfig 클래스에서 @Autowired 어노테이션으로 주입한다.).
@Log
public class CustomUserDetailsService implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		return null;
	}
	
}
