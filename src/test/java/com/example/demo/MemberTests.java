package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.Member;
import com.example.dto.MemberRole;
import com.example.persistence.MemberRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTests {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
//	@Test
//	public void testInsert() {
//		for (int i = 0; i <= 100; i++) {
//			Member member = new Member();
//			member.setUId("user" + i);
//			member.setUName("사용자" + i);
//			member.setUPw("pw" + i);
//			
//			MemberRole memberRole = new MemberRole();
//			
//			if (i <= 80) {
//				memberRole.setRoleName("BASIC");
//			} else if(i <= 90) {
//				memberRole.setRoleName("MANAGER");
//			} else {
//				memberRole.setRoleName("ADMIN");
//			}
//			
//			member.setRoles(Arrays.asList(memberRole));
//			
//			memberRepository.save(member);
//		};
//	}
	
//	@Test
//	public void testRead() {
//		Optional<Member> result = memberRepository.findById("user1");
//		result.ifPresent(member -> log.info("member : " + member));
//	}
	
	@Test
	public void testUpdateOldMember() {
		List<String> ids = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			ids.add("user" + i);
		}
		
		memberRepository.findAllById(ids).forEach(member -> {
			member.setUPw(passwordEncoder.encode(member.getUPw()));
			
			memberRepository.save(member);
		});
	}
}
