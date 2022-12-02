package top.abr.fwsample.ch2_2.service;

import org.springframework.stereotype.Service;
import top.abr.fwsample.ch2_2.POJO.user_identity;

import java.util.Map;

import static java.util.Map.entry;

@Service
public class user_service_impl implements user_service {
	private static final Map<String, String> password = Map.ofEntries(
		entry("admin", "998244353"),
		entry("0", "0"),
		entry(" ", " ")
	);

	@Override
	public user_identity.error login(user_identity user) {
		var password = user_service_impl.password.get(user.getName());
		if (password == null) {return user_identity.error.nonexistent_user;}
		if (password.equals(user.getPassword()) == false) {return user_identity.error.incorrect_password;}
		return user_identity.error.no_error;
	}
	@Override
	public user_identity.error register(user_identity user) {
		if (user.getName().isEmpty()) {return user_identity.error.empty_user_name;}
		if (user.getPassword().isEmpty()) {return user_identity.error.empty_password;}
		if (user.getConfirmPassword().isEmpty()) {return user_identity.error.empty_confirm_password;}
		if (user.getPassword().equals(user.getConfirmPassword()) == false) {return user_identity.error.confirm_password_inconsistent;}
		if (password.containsKey(user.getName())) {return user_identity.error.existent_user;}
		password.put(user.getName(), user.getPassword());
		return user_identity.error.no_error;
	}
}
