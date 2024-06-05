package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.service.AaaService;

@SpringBootTest
public class TestExample {
	
	@Autowired
	AaaService aaaService;
	
	
//	@Test
//	public void aaaInsert() {
//		aaaService.insert();
//	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void testEncoder() {
		String password = "1234"; // 사용자가 입력
		
		// DB에 저장된 암호화된 비밀번호 (단반향 암호화) 복호화는 불가능
		String enPwd = passwordEncoder.encode(password);
		System.out.println("enPwd : " + enPwd);
		
		// 암호화 시킨 데이터와 사용자가 입력된 데이터가 같은지 맞지 않은지 비교
		boolean matchResult = passwordEncoder.matches(password, enPwd);
		System.out.println("match : " + matchResult);
	}
	
}
