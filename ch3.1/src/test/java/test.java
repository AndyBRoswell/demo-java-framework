import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import persistence.user;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class test {
	@Test
	public void MyBatis_demo() {
		try {
			final InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			final SqlSessionFactory SQL_session_factory = new SqlSessionFactoryBuilder().build(config);
			final SqlSession SQL_session = SQL_session_factory.openSession();
			final var mybatis_prefix = "mybatis_mapper.user-mapper.";
			final List<user> expected_users = new ArrayList<>();
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
				expected_users.add(user);
				SQL_session.insert(mybatis_prefix + "add_user", user);
			}
			assertEquals(n, expected_users.size());
			// select
			for (var expected_user : expected_users) {
				final user actual_user = SQL_session.selectOne(mybatis_prefix + "select_user_by_id", expected_user.getId());
				assertTrue(expected_user.equals(actual_user));
			}
			// update
			for (var user : expected_users) {
				final StringBuilder name_string_builder = new StringBuilder();
				final int l = random.nextInt(1, 32);
				for (var j = 0; j < l; ++j) {name_string_builder.append((char)random.nextInt(0x20, 0x7E));}
				user.setName(name_string_builder.toString());
				user.setSex(random.nextBoolean() == true ? "M" : "F");
				SQL_session.update(mybatis_prefix + "update_user", user);
			}
			// select
			List<user> actual_users = SQL_session.selectList(mybatis_prefix + "select_all_users");
			final var user_comparator = Comparator.comparingLong(user::getId).thenComparing(user::getName).thenComparing(user::getSex);
			expected_users.sort(user_comparator);
			actual_users.sort(user_comparator);
			assertEquals(expected_users.size(), actual_users.size());
			for (var i = 0; i < n; ++i) {
				assertTrue(expected_users.get(i).equals(actual_users.get(i)));
			}
			// delete
			Collections.shuffle(expected_users);
			for (var i = n - 1; i >= n / 2; --i) {
				SQL_session.delete(mybatis_prefix + "delete_user", expected_users.get(i).getId());
				expected_users.remove(i);
			}
			// select
			actual_users = SQL_session.selectList(mybatis_prefix + "select_all_users");
			expected_users.sort(user_comparator);
			actual_users.sort(user_comparator);
			assertEquals(expected_users.size(), actual_users.size());
			for (var i = 0; i < actual_users.size(); ++i) {
				assertTrue(expected_users.get(i).equals(actual_users.get(i)));
			}
			// truncate
			SQL_session.delete(mybatis_prefix + "clear_users");
			// select
			actual_users = SQL_session.selectList(mybatis_prefix + "select_all_users");
			assertEquals(0, actual_users.size());
			SQL_session.commit();
			SQL_session.close();
		}
		catch (IOException e) {e.printStackTrace();}
	}
}
