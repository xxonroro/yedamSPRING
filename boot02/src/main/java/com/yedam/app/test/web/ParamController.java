package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class ParamController {
	// 요청 파라미터의 경우 Content-type은 application/x-www-form-urlencoded 이다.
	
	@RequestMapping(path="/comobj", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "path : / comobj\n";
		result += "\t employee_id : " + empVO.getEmployeeId();
		result += "\t last_name : " + empVO.getLastName();
		
		return result;
	}
	
	@RequestMapping(path="/reqparm", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam(@RequestParam Integer employeeId, String lastName, @RequestParam(name = "message", defaultValue = "No message", required = true) String message) {
		String result = "";
		result += "path : / comobj\n";
		result += "\t employee_id : " + employeeId;
		result += "\t last_name : " + lastName;
		
		return result;
	}
	
	
	// @PathVariable : 경로에 값을 포함하는 방식, 단일 값  
	// Method는 상관없음
	// Content-type도 상관없음 
   @RequestMapping("path/{id}")
   @ResponseBody
   public String pathVariable(@PathVariable String id) {
      String result = "";
      result += "path : /path/{id} \n";
      result += "\t id : " + id;
      
      return result;
   }
   
   @PostMapping("resbody")
   @ResponseBody
   public String requestBody(@RequestBody EmpVO empVO) {
	   String result = "path : /resbody \n";
	   result += "\t employee_id : " + empVO.getEmployeeId();
	   result += "\t last_name : " + empVO.getLastName();
	   
	   return result;
   }
	
   @PostMapping("resbodyList")
   @ResponseBody
   public String requestBodyList(@RequestBody List<EmpVO> list) {
	   String result = "path : /resbody \n";
	   for(EmpVO empVO : list) {
		   result += "\t employee_id : " + empVO.getEmployeeId();
		   result += "\t last_name : " + empVO.getLastName();
		   result += "\n";
	   }
	   
	   return result;
   }
	
	
}
