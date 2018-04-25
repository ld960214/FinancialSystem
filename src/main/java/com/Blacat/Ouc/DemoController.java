package com.Blacat.Ouc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("/a123")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello() {

		return "hello";
	}

}
