package top.abr.fwsample.ch2_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") // common prefix of URL
public class index_controller { // for the requests from index.jsp
	@RequestMapping("login")
	public String login() {
		return "login"; // return view name resolved by view solver
	}
	@RequestMapping("reg")
	public String register() {
		return "register";
	}
}
