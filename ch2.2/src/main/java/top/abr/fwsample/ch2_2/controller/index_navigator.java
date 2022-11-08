package top.abr.fwsample.ch2_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.abr.fwsample.ch2_2.POJO.user_identity;
import top.abr.fwsample.ch2_2.service.user_service;

import javax.servlet.http.HttpSession;
import java.util.Map;

import static java.util.Map.entry;

@Controller
@RequestMapping("/user/")
public class index_navigator {
	public static final Map<user_identity.error, String> error_hint = Map.ofEntries(
		entry(user_identity.error.empty_user_name, "用户名不能为空"),
		entry(user_identity.error.empty_password, "密码不能为空"),
		entry(user_identity.error.empty_confirm_password, "确认密码不能为空"),
		entry(user_identity.error.existent_user, "用户已存在"),
		entry(user_identity.error.confirm_password_inconsistent, "密码与确认密码不一致"),
		entry(user_identity.error.nonexistent_user, "用户不存在"),
		entry(user_identity.error.incorrect_password, "密码错误")
	);

	@Autowired
	private user_service user_service;

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
		var ret = user_service.login(user);
		if (ret == user_identity.error.no_error) {
			HTTP_session.setAttribute("u", user);
			return "main";
		}
		model.addAttribute("error_message", error_hint.get(ret));
		return "login";
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
