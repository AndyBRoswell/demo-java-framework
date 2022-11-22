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
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/session")
public class index_navigator {
	private static final LinkedHashMap<String, String> halls = new LinkedHashMap<>();
	private static final LinkedHashMap<String, String> levels = new LinkedHashMap<>();

	@Autowired
	private film_session_service film_session_service;

	static {
		final String[] Halls = { "1号厅", "2号厅", "3号厅", "4号厅", "5号厅", "6号IMAX GT厅", "7号厅", "8号IMAX GT厅", "9号厅", "10号杜比影院", "11号厅", "12号杜比影院", "13号CINITY厅", "14号CINITY厅" };
		for (var Hall : Halls) {halls.put(Hall, Hall);}

		final String[] Levels = { "正常", "重要", "关键" };
		for (var Level : Levels) {levels.put(Level, Level);}
	}

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
	public String list_film_sessions(Model model) {
		model.addAttribute("film_sessions", film_session_service.get_film_sessions());

		return "sessions";
	}
}
