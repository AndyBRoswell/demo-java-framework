package top.abr.fwsample.ch2_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.abr.fwsample.ch2_3.service.film_session_service;

@Controller
@RequestMapping("/session")
public class index_navigator {
	@Autowired
	private film_session_service film_session_service;

	@GetMapping("add")
	public String send_add_session_page(Model model) {
		
	}
}
