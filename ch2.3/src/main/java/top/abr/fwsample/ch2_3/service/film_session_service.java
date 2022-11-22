package top.abr.fwsample.ch2_3.service;

import top.abr.fwsample.ch2_3.POJO.film_session;

import java.util.ArrayList;

public interface film_session_service {
	film_session.error add_film_session(film_session s);
	ArrayList<film_session> get_film_sessions();
}
