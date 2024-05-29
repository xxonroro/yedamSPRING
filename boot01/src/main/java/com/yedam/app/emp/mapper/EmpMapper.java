package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.emp.service.EmpVO;

@Mapper
public interface EmpMapper {
	// DAO - Data Accept Object (DB에 접근할 때 사용하는 객체)
	
	// 전체 조회 - (SELECT 문, 조건 X, 결과가 여러 건.)
	public List<EmpVO> selectEmpAll();
	
	// 단건 조회
	
	
	// 등록
	
	// 수정
	
	// 삭제
}
