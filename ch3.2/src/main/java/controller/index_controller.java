package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import persistence.user;
import persistence.user_mapper;

import java.time.Instant;
import java.util.Random;

@Controller
public class index_controller {
	@Autowired
	private user_mapper user_mapper;
	@RequestMapping("/test")
	public String test() {
		final int n = 100;
		final var random = new Random(Instant.now().getEpochSecond());
		// insert
		for (var i = 0; i < n; ++i) {
			final user user = new user();
			user.setId(random.nextLong());
			final StringBuilder name_string_builder = new StringBuilder();
			final int l = random.nextInt(1, 32);
			for (var j = 0; j < l; ++j) {name_string_builder.append((char)random.nextInt(0x20, 0x7E));}
			user.setName(name_string_builder.toString());
			user.setSex(random.nextBoolean() == true ? "M" : "F");

		}

		return "test";
	}
}
