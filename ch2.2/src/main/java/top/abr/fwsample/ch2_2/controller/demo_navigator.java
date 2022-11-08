package top.abr.fwsample.ch2_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/req-param-demo")
public class demo_navigator {
	@RequestMapping("/req-param-demo")
	public String open_req_param_demo_page() {
		return "req-param-demo";
	}
}
