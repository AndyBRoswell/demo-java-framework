package top.abr.fwsample.ch2_2.service;

import top.abr.fwsample.ch2_2.POJO.user_identity;

public interface user_service {
	String login(user_identity user);
	String register(user_identity user);
}
