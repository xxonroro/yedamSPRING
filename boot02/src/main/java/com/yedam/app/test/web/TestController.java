package com.yedam.app.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class TestController {
	
//	@RequestMapping(path = "/test", method = RequestMethod.GET)
	@GetMapping("/test")
	@ResponseBody
	public String urlTest(String keyword) {
		return "Server Respone : " + keyword;
	}
	
//	@RequestMapping(path = "/test", method = RequestMethod.POST)
	@PostMapping("/test")
	@ResponseBody
	public String urlPostTest(String keyword) {
		return "Server Respone : INSERT - " + keyword;
	}
	
	@Autowired
	EmpService empService;
	
	@GetMapping("thymeleaf")
	public String thymeleafTest(Model model) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "test";
	}
}

