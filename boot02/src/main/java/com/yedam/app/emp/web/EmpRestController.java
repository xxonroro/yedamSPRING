package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RestController // @Controller + 모든 메서드에 @ResponseBody를 적용 즉 AJAX로 통신 (모델 사용 X - 페이지가 필요 없다.)
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	// 전체 조회 (GET)
	@GetMapping("emps")
	public List<EmpVO> empList() {
		return empService.empList();
	}
	
	// 단건 조회 (GET) (경로에 값을 받아오는 방식) // 변수와 매개변수 이름이 다르면 name 속성 사용
	@GetMapping("emps/{id}")
	public EmpVO empInfo(@PathVariable(name = "id") Integer employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		
		return empService.empInfo(empVO);
	}
	
	// 등록 (POST)
	@PostMapping("emps")
	public int empInsert(@RequestBody EmpVO empVO) {
		return empService.empInsert(empVO);
	}
	
	// 수정 (PUT) (경로에 값을 받아오는 방식) 경로를 통해서 수정할 Target, 수정할 정보는 JSON 포맷으로 받는다.
	@PutMapping("emps/{employeeId}")
	public Map<String, Object> empUpdate(@PathVariable Integer employeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);	
		
		return empService.empUpdate(empVO);
	}
	
	
	// 삭제 (DELETE) (경로에 값을 받아오는 방식)
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> eempDelete(@PathVariable Integer employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		
		return empService.empDelete(empVO);
	}
}
