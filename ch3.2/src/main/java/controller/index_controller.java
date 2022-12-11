package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import persistence.user;
import persistence.user_mapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class index_controller {
	@Autowired
	private user_mapper user_mapper;
	@RequestMapping("/test")
	public String test() {
		final int n = 100;
		final var random = new Random(Instant.now().getEpochSecond());
		final List<Long> user_id = new ArrayList<>();
		// insert
		for (var i = 0; i < n; ++i) {
			final user user = new user();
			final Long id = random.nextLong();
			user_id.add(id);
			user.setId(id);
			final StringBuilder name_string_builder = new StringBuilder();
			final int l = random.nextInt(1, 16);
			for (var j = 0; j < l; ++j) {name_string_builder.append((char)random.nextInt(0x20, 0x7E));}
			user.setName(name_string_builder.toString());
			user.setSex(random.nextBoolean() == true ? "M" : "F");
			user_mapper.add_user(user);
		}
		// update
		for (var i = 0; i < n / 2; ++i) {
			final int index = random.nextInt(0, user_id.size());
			final user user = user_mapper.select_user_by_id(user_id.get(index));
			final Long id = random.nextLong();
			user.setId(id);
			final StringBuilder name_string_builder = new StringBuilder();
			final int l = random.nextInt(1, 16);
			for (var j = 0; j < l; ++j) {name_string_builder.append((char)random.nextInt(0x20, 0x7E));}
			user.setName(user.getName() + name_string_builder);
			user.setSex(user.getSex().equals("M") ? "F" : "M");
			user_mapper.update_user(user);
		}
		// delete
		for (var i = n - 1; i >= n / 2; --i) {
			user_mapper.delete_user(user_id.get(i));
		}

	}
}
