package com.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello" ,produces="application/json" )
public class DemoController {
	@GetMapping("/welcome")
	public String showPage() {
		return "welo come rest service";
	}
	
	

}
