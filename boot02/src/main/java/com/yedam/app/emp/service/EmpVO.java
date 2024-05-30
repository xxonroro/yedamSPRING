package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	   private Integer employeeId; // Primary Key는 반드시 값이 있어야 하기 때문에 null 값을 받을 수 있는 Wrapper 타입으로 선언하였다.
	   private String firstName;
	   private String lastName;
	   private String email;
	   private String phoneNumber;
	   private Date hireDate;
	   private String jobId;
	   private double salary;
	   private double commissionPct;
	   private int managerId;
	   private int departmentId;
}
