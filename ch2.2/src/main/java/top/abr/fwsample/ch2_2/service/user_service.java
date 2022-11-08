package top.abr.fwsample.ch2_2.service;

import top.abr.fwsample.ch2_2.POJO.user_identity;

public interface user_service {
	user_identity.error login(user_identity user);
	user_identity.error register(user_identity user);
}
