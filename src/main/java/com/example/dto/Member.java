package com.example.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * 회원에 대한 클래스 생성시 일반적으로 User라는 용어를 사용하지만 User라는 타입은 이미 스프링 시큐리티에서 이용하고 있기 때문에 Member라는 이름을 이용한다.
 * username, password 등의 용어도 마찬가지의 이유로  uid, upw와 같은 식으로 이용한다.
 * */
@Getter
@Setter
@Entity
@Table(name = "tbl1_members")
@EqualsAndHashCode(of = "uId")
@ToString
public class Member {
	
	@Id
//	private String uid; // 어떤 이유 때문인지는 모르겠지만 칼럼명을 uid로 하려하면 테이블이 생성되지 않는다.
	private String uId;
	private String uPw;
	private String uName;
	
	@CreationTimestamp
	private LocalDateTime regdate; // regdate에 값이 들어가지 않는다(?)
	@UpdateTimestamp
	private LocalDateTime updatedate;
	
	// MemberRole은 정보에 대한 접근 방식 자체가 '회원'을 통한 접근이므로 별도의 연관관계를 설정하지 않는 단방향 방식으로 둔다.
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "member")
	private List<MemberRole> roles;
	
}
