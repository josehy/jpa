package com.jcpdev.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString(callSuper = true)
@Table(name="users")
public class Users extends BaseEntity{
	
	@Id		//기본키 컬럼
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//auto increment (sequence)
	private Long mno;   //long : 기본형 타입, Long : long에대한 래퍼클래스
	
	@Column(nullable = false, unique = true)  //컬럼명 지정.변수명과같으면 생략
	private String email;					//널허용,유니크 등 설정 
	
	@Column(updatable = false)
	private String password;
	
	@Column
	private String name;
}




