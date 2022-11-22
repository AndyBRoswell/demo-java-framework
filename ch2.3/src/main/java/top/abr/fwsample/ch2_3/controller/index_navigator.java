package top.abr.fwsample.ch2_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.abr.fwsample.ch2_3.service.film_session_service;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/session")
public class index_navigator {
	@Autowired
	private film_session_service film_session_service;

	@GetMapping("add")
	public String send_add_session_page(Model model) {
		Map<String,String> halls= Map.ofEntries(
			Map.entry("1号厅","1号厅")
		);
	}
}
