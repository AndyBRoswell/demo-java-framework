package top.abr.fwsample.ch2_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.abr.fwsample.ch2_2.POJO.user_identity;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class index_navigator {
	@GetMapping("login")
	public String open_login_page() {
		return "login"; // go to login.jsp
	}

	@GetMapping("reg")
	public String open_register_page() {
		return "register";
	}

	@PostMapping("login")
	public String login(user_identity user, HttpSession HTTP_session, Model model) {
		if (user.getName().equals("admin") && user.getPassword().equals("998244353")) {
			HTTP_session.setAttribute("u", user);
			return "main";
		}
		else {
			model.addAttribute("error_message", "用户名或密码错误");
			return "login";
		}
	}

	@PostMapping("reg")
	public String register(user_identity user, Model model) {
		if (user.getPassword().equals(user.getConfirmPassword())) {
			return "login";
		}
		else {
			model.addAttribute("error_message", "注册失败：密码与确认密码不一致");
			return "register";
		}
	}
}
