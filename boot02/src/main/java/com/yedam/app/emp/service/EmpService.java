package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
	// 전체 사원정보 조회
	public List<EmpVO> empList();
	
	// 사원 정보 조회
	public EmpVO empInfo(EmpVO empVO);
	
	public int empInsert(EmpVO empVO);
	
	// 사원 정보 수정
	public Map<String, Object> empUpdate(EmpVO empVO);
	
	// 사원 정보 삭제
	public Map<String, Object> empDelete(EmpVO empVO);
}
