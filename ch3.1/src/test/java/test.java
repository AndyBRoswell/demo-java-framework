import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import persistence.user;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
	@Test
	public static void MyBatis_demo() {
		try {
			final InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			final SqlSessionFactory SQL_session_factory = new SqlSessionFactoryBuilder().build(config);
			final SqlSession SQL_session = SQL_session_factory.openSession();
			final var mybatis_prefix = "mybatis_mapper.user-mapper.";
			final Set<user> control_group = new HashSet<>();
			final long n = 100L;
			final var random = new Random(Instant.now().getEpochSecond());
			for (var i = 0; i < n; ++i) {
				final user user = new user();
				user.setId(random.nextLong());
				final StringBuilder name_string_builder = new StringBuilder();
				final int l = random.nextInt(1, 32);
				for (var j = 0; j < l; ++j) {name_string_builder.append(random.nextInt(0x20, 0x7E));}
				user.setName(name_string_builder.toString());
				user.setSex(random.nextBoolean() == true ? "M" : "F");
				control_group.add(user);
				SQL_session.insert(mybatis_prefix + "add_user", user);
			}
			for (var expected_user : control_group) {
				final user returned_user = SQL_session.selectOne("mybatis_mapper.user-mapper.select_user_by_id", expected_user.getId());
				assertEquals(returned_user, expected_user);
			}
			for (var user : control_group) {
				user.setId(random.nextLong());
				final StringBuilder name_string_builder = new StringBuilder();
				final int l = random.nextInt(1, 32);
				for (var j = 0; j < l; ++j) {name_string_builder.append(random.nextInt(0x20, 0x7E));}
				user.setName(name_string_builder.toString());
				user.setSex(random.nextBoolean() == true ? "M" : "F");
				SQL_session.update("mybatis_mapper.user-mapper.update_user", user);
			}
			for (var expected_user : control_group) {
				final user returned_user = SQL_session.selectOne("mybatis_mapper.user-mapper.select_user_by_id", expected_user.getId());
				assertEquals(returned_user, expected_user);
			}
			SQL_session.delete("mybatis_mapper.user-mapper.delete_user", 2L);
			final List<user> user_list = SQL_session.selectList("mybatis_mapper.user-mapper.select_all_users");
			for (final user user : user_list) {
				System.out.println(user);
			}
			SQL_session.commit();
			SQL_session.close();
		}
		catch (IOException e) {e.printStackTrace();}
	}
}
