package com.yedam.app;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot02ApplicationTests {	
	
	
	@Autowired
	EmpMapper empMapper;
	
	@DisplayName("전체 조회")
	@Test
	public void empList() {
		List<EmpVO> list = empMapper.selectEmpAll();
		
		Assertions.assertTrue(!list.isEmpty()); 
	}
	
	@DisplayName("단건 조회")
	@Test
	public void empInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		
		Assertions.assertEquals(findVO.getLastName(), "King");
	}
	
	@DisplayName("등록")
//	@Test
	public void empInsert() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("kdHong@google.com");
		empVO.setJobId("IT_PROG");
		
		int result = empMapper.insertEmpInfo(empVO);
		
		System.out.println(empVO.getEmployeeId());
		Assertions.assertEquals(result, 1);
	}
	
	@DisplayName("수정")
	@Test
	public void empUpdate() {
		// 1) 대상 조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(555);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
		
		// 2) 정보 수정
		findVO.setLastName("Hong");
		int result = empMapper.updateEmpInfo(findVO.getEmployeeId(), findVO);
		
		Assertions.assertEquals(result, 1);
	}
	
	@DisplayName("삭제")
//	@Test
	public void empDelete() {
		int result = empMapper.deleteEmpInfo(556);
		Assertions.assertEquals(result, 1);
	}
}
