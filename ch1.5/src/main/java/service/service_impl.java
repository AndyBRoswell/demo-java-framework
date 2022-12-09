package service;

import DAO.DAO;
import entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Random;

@Service
public class service_impl implements service {
	@Autowired
	public DAO test_DAO;
	@Override
	public void test_JDBC() {
		final var insert_SQL = "insert into spring_test.user values(?,?,?)";
		final var select_SQL = "select * from spring_test.user";
		final var truncate_SQL = "truncate table spring_test.user";
		final var random = new Random(Instant.now().getEpochSecond());
		for (long i = 1; i <= 10; ++i) {
			test_DAO.update(insert_SQL, new Object[]{ i, "老王" + random.nextLong(), random.nextBoolean() == true ? "男" : "女", });
		}
		List<user> user_list = test_DAO.query(select_SQL, null);
		for (var user : user_list) {System.out.println(user);}
		test_DAO.update(truncate_SQL, null);
	}
}
