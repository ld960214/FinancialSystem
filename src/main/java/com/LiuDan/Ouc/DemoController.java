package com.LiuDan.Ouc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello() {

		return "hello";
	}

}
