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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
	@Test
	public void MyBatis_demo() {
		try {
			final InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			final SqlSessionFactory SQL_session_factory = new SqlSessionFactoryBuilder().build(config);
			final SqlSession SQL_session = SQL_session_factory.openSession();
			final var mybatis_prefix = "mybatis_mapper.user-mapper.";
			final List<user> expected_users = new ArrayList<>();
			final long n = 100L;
			final var random = new Random(Instant.now().getEpochSecond());
			for (var i = 0; i < n; ++i) {
				final user user = new user();
				user.setId(random.nextLong());
				final StringBuilder name_string_builder = new StringBuilder();
				final int l = random.nextInt(1, 8);
				for (var j = 0; j < l; ++j) {name_string_builder.append((char)random.nextInt(0x20, 0x7E));}
				user.setName(name_string_builder.toString());
				user.setSex(random.nextBoolean() == true ? "M" : "F");
				expected_users.add(user);
				SQL_session.insert(mybatis_prefix + "add_user", user);
			}
			for (var expected_user : expected_users) {
				final user actual_user = SQL_session.selectOne(mybatis_prefix + "select_user_by_id", expected_user.getId());
				assertEquals(expected_user, actual_user);
			}
			for (var user : expected_users) {
				user.setId(random.nextLong());
				final StringBuilder name_string_builder = new StringBuilder();
				final int l = random.nextInt(1, 32);
				for (var j = 0; j < l; ++j) {name_string_builder.append((char)random.nextInt(0x20, 0x7E));}
				user.setName(name_string_builder.toString());
				user.setSex(random.nextBoolean() == true ? "M" : "F");
				SQL_session.update(mybatis_prefix + "update_user", user);
			}
			final List<user> actual_users = SQL_session.selectList("mybatis_mapper.user-mapper.select_all_users");
			assertEquals(expected_users, actual_users);
			SQL_session.commit();
			SQL_session.close();
		}
		catch (IOException e) {e.printStackTrace();}
	}
}
