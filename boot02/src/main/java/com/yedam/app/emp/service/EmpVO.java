package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	   private Integer employeeId; // Primary Key는 반드시 값이 있어야 하기 때문에 null 값을 받을 수 있는 Wrapper 타입으로 선언하였다.
	   private String firstName;
	   private String lastName;
	   private String email;
	   private String phoneNumber;
	  
	   // HanlderAdapter가 파라미터 자동 매핑 시 적용할 포맷
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   private Date hireDate;
	   
	   private String jobId;
	   private double salary;
	   private double commissionPct;
	   private int managerId;
	   private int departmentId;
}
