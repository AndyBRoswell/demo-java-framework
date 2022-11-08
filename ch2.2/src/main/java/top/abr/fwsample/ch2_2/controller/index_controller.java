package top.abr.fwsample.ch2_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.abr.fwsample.ch2_2.POJO.user_form_content;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class index_controller {
	@GetMapping("login")
	public String open_login_page() {
		return "login";
	}

	@GetMapping("reg")
	public String open_register_page() {
		return "register";
	}

	@PostMapping("login")
	public String login(user_form_content user, HttpSession HTTP_session, Model model) {
		if (user.get_name().equals("admin") && user.get_password().equals("998244353")) {
			HTTP_session.setAttribute("u", user);
			return "main"; // go to main.jsp
		}
		else {
			model.addAttribute("error_message", "用户名或密码错误");
			return "login";
		}
	}

	@PostMapping("reg")
	public String register(user_form_content user, Model model) {
		if (user.get_name().equals("admin") && user.get_password().equals("998244353")) {
			return "login";
		}
		else {
			model.addAttribute("user_name", user.get_name());
			return "register";
		}
	}
}
