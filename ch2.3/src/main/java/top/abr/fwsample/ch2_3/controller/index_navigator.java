package top.abr.fwsample.ch2_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.abr.fwsample.ch2_3.POJO.film_session;
import top.abr.fwsample.ch2_3.service.film_session_service;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/session")
public class index_navigator {
	private static final Map<String, String> halls = Map.ofEntries(
		Map.entry("1号厅", "1号厅"),
		Map.entry("2号厅", "2号厅"),
		Map.entry("3号厅", "3号厅"),
		Map.entry("4号厅", "4号厅"),
		Map.entry("5号厅", "5号厅"),
		Map.entry("6号IMAX GT厅", "6号IMAX GT厅"),
		Map.entry("7号厅", "7号厅"),
		Map.entry("8号IMAX GT厅", "8号IMAX GT厅"),
		Map.entry("9号厅", "9号厅"),
		Map.entry("10号杜比影院", "10号杜比影院"),
		Map.entry("11号厅", "11号厅"),
		Map.entry("12号杜比影院", "12号杜比影院"),
		Map.entry("13号CINITY厅", "13号CINITY厅"),
		Map.entry("14号CINITY厅", "14号CINITY厅")
	);
	private static final Map<String, String> levels = Map.ofEntries(
		Map.entry("正常", "正常"),
		Map.entry("重要", "重要"),
		Map.entry("关键", "关键")
	);

	@Autowired
	private film_session_service film_session_service;

	@GetMapping("add")
	public String send_add_session_page(Model model) {
		model.addAttribute("film-session", new film_session());
		model.addAttribute("halls", halls);
		model.addAttribute("levels", levels);

		return "add-session"; // view name
	}

	@PostMapping("add")
	public String add_film_session(@ModelAttribute film_session session, Model model) {
		if (film_session_service.add_film_session(session) == film_session.error.no_error) {
			return "redirect:/session/list";
		}
		else {
			model.addAttribute("halls", halls);
			model.addAttribute("levels", levels);

			return "add-session"; // view name
		}
	}

	@GetMapping("list")
	public String list_film_sessions(Model model){
		model.addAttribute("film_sessions", film_session_service.get_film_sessions());

		return "sessions";
	}
}
