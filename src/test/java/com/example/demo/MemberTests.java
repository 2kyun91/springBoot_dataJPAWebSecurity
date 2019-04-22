package com.example.demo;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
	
	@Test
	public void testInsert() {
		for (int i = 0; i <= 100; i++) {
			Member member = new Member();
			member.setUId("user" + i);
			member.setUName("사용자" + i);
			member.setUPw("pw" + i);
			
			MemberRole memberRole = new MemberRole();
			
			if (i <= 80) {
				memberRole.setRoleName("BASIC");
			} else if(i <= 90) {
				memberRole.setRoleName("MANAGER");
			} else {
				memberRole.setRoleName("ADMIN");
			}
			
			member.setRoles(Arrays.asList(memberRole));
			
			/*
			 * Member 엔티티와 MemberRole 엔티티를 동시에 저장하기 때문에 에러가 발생한다.
			 * 엔티티들은 영속관계를 한 번에 처리하지 못하기 때문에 cascade 설정을 추가해야 한다.
			*/
			memberRepository.save(member);
		};
	}
}
