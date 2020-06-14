package com.sd.security.Lab1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String hello(){
		return "<h1>Hello World</h1>"; 
	}
}
