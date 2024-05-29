package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class EmpVO {
	   private int employeeId;
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
