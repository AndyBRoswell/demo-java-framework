package top.abr.fwsample.ch2_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class index_controller { // for the requests from index.jsp
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/reg")
	public String register() {
		return "register";
	}
}
