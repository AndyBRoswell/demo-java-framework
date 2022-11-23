package top.abr.fwsample.ch2_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import top.abr.fwsample.ch2_4.POJO.speaker;

import java.util.ArrayList;

@Controller
public class index_controller {
	private static final ArrayList<speaker> speakers = new ArrayList<>();

	@GetMapping("/query")
	@ResponseBody
	public Object list_speakers() {

	}

	@PostMapping("/add")
	@ResponseBody
	public Object add_speaker(@RequestBody speaker s) {

	}
}
