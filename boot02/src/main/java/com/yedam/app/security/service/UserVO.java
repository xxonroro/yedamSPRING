package com.yedam.app.security.service;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

//implements UserDetails 대신 내가 만든 UserDetails

@Data
public class UserVO{
	private String loginId;
	private String password;
	private String roleName;
}
