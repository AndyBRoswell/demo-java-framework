package annotation.controller;

import annotation.service.test_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class test_controller {
	@Autowired
	private test_service test_service;
	public void save() {
		test_service.save();
		System.out.println("test controller save");
	}
}
