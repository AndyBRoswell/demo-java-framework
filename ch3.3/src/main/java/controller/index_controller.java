package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import persistence.user;
import persistence.user_mapper;
import util.random;

import java.util.*;

@Controller
public class index_controller {
	@Autowired
	private user_mapper user_mapper;
	private String get_formatted_JSON(final Object value) throws JsonProcessingException {
		final ObjectMapper object_mapper = new ObjectMapper();
		return object_mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
	}
	@GetMapping("/test")
	@ResponseBody
	public String test() throws JsonProcessingException {
		final int n = 20;
		final List<Long> user_id = new ArrayList<>();
		// insert
		for (var i = 0; i < n; ++i) {
			final user user = new user();
			final Long id = random.Long();
			user_id.add(id);
			user.setId(id);
			user.setName(random.ASCII_string(1, 16));
			user.setSex(random.Bool() == true ? "M" : "F");
			user_mapper.add_user(user);
		}
		// update
		for (var i = 0; i < n / 2; ++i) {
			final int index = random.Int(0, user_id.size());
			final user user = user_mapper.select_user_by_id(user_id.get(index));
			user.setId(random.Long());
			user.setName(user.getName() + random.ASCII_string(1, 16));
			user.setSex(user.getSex().equals("M") ? "F" : "M");
			user_mapper.update_user(user);
		}
		// delete
		for (var i = n - 1; i >= n / 2; --i) {
			user_mapper.delete_user(user_id.get(i));
		}
		// select
		final var users = user_mapper.select_all_users();
		// clear
		user_mapper.clear_users();
		// return
		return get_formatted_JSON(users);
	}
	@GetMapping("/test_MySQL_select_users_by_map")
	@ResponseBody
	public String test_MySQL_select_users_by_map() throws JsonProcessingException {
		final int n = 3;
		final user user = new user();
		user.setName("老陈");
		user.setSex("男");
		// insert
		for (var i = 0; i < n; ++i) {
			user.setId((long)i);
			user_mapper.add_user(user);
		}
		// select
		final Map<String, Object> param = new HashMap<>();
		param.put("name", user.getName());
		param.put("sex", user.getSex());
		final var result = user_mapper.MySQL_select_users_by_map(param);
		// delete
		for (var i = 0; i < n; ++i) {user_mapper.delete_user((long)i);}
		// return
		return get_formatted_JSON(result);
	}
	@GetMapping("/test_MySQL_select_users_by_bean")
	@ResponseBody
	public String test_MySQL_select_users_by_bean() throws JsonProcessingException {
		final int n = 2;
		// insert
		final user user = new user();
		user.setName("刘一");
		user.setSex("男");
		for (var i = 0; i < n; ++i) {
			user.setId((long)i);
			user_mapper.add_user(user);
		}
		// select
		final var result = user_mapper.MySQL_select_users_by_bean(user);
		// delete
		for (var i = 0; i < n; ++i) {user_mapper.delete_user((long)i);}
		// return
		return get_formatted_JSON(result);
	}
	@GetMapping("/test_MySQL_select_users_by_param_annotation")
	@ResponseBody
	public String test_MySQL_select_users_by_param_annotation() throws JsonProcessingException {
		final int n = 5;
		// insert
		final user user = new user();
		user.setName("陈二");
		user.setSex("男");
		for (var i = 0; i < n; ++i) {
			user.setId((long)i);
			user_mapper.add_user(user);
		}
		// select
		final var result = user_mapper.MySQL_select_users_by_param_annotation(user.getName(), user.getSex());
		// delete
		for (var i = 0; i < n; ++i) {user_mapper.delete_user((long)i);}
		// return
		return get_formatted_JSON(result);
	}
	@GetMapping("/test_add_user_with_auto_increment")
	@ResponseBody
	public String test_add_user_with_auto_increment() throws JsonProcessingException {
		final int n = 10;
		// insert
		for (var i = 0; i < n; ++i) {
			final user user = new user();
			user.setName("张三" + random.ASCII_char());
			user.setSex("男");
			user_mapper.add_user_with_auto_increment(user);
		}
		// select
		final var result = user_mapper.select_all_users();
		// delete
		for (var user : result) {user_mapper.delete_user(user.getId());}
		// return
		return get_formatted_JSON(result);
	}
	@GetMapping("/test_add_user_with_custom_primary_key")
	@ResponseBody
	public String test_add_user_with_custom_primary_key() throws JsonProcessingException {
		final int n = 10;
		// insert
		for (var i = 0; i < n; ++i) {
			final user user = new user();
			user.setName("李四" + random.ASCII_char());
			user.setSex("男");
			user_mapper.add_user_with_custom_primary_key(user);
		}
		// select
		final var result = user_mapper.select_all_users();
		// delete
		for (var user : result) {user_mapper.delete_user(user.getId());}
		// return
		return get_formatted_JSON(result);
	}
	@GetMapping("/test_1_to_1")
	@ResponseBody
	public String test_1_to_1() throws JsonProcessingException {
		return "";
	}
}
