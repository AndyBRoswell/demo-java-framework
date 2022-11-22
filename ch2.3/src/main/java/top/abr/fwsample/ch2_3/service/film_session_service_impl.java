package top.abr.fwsample.ch2_3.service;

import org.springframework.stereotype.Service;
import top.abr.fwsample.ch2_3.POJO.film_session;

import java.util.ArrayList;

@Service
public class film_session_service_impl implements film_session_service {
	private static final ArrayList<film_session> film_sessions = new ArrayList<>(); // this static variable simulates the database

	@Override
	public film_session.error add_film_session(film_session session) {
		film_sessions.add(session);
		return film_session.error.no_error;
	}
	@Override
	public ArrayList<film_session> get_film_sessions() {
		return film_sessions;
	}
}
