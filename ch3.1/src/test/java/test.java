import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import persistence.user;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		try {
			final InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			final SqlSessionFactory SQL_session_factory = new SqlSessionFactoryBuilder().build(config);
			final SqlSession SQL_session = SQL_session_factory.openSession();
			final var mybatis_prefix = "mybatis_mapper.user-mapper.";
			final Set<user> control_group = new HashSet<>();
			final long n = 100L;
			final var random = new Random(Instant.now().getEpochSecond());
			for (var i = 1; i <= n; ++i) {
				final user u = new user();
				u.setId(random.nextLong());
				final StringBuilder name_string_builder = new StringBuilder();
				final int l = random.nextInt(1, 32);
				for (var j = 0; j < l; ++j) {name_string_builder.append(random.nextInt(0x20, 0x7E));}
				u.setName(name_string_builder.toString());
				u.setSex(random.nextBoolean() == true ? "M" : "F");
				control_group.add(u);
				SQL_session.insert(mybatis_prefix + "add_user");
			}
			final user user_selected = SQL_session.selectOne("mybatis_mapper.user-mapper.select_user_by_id", 1L);
			System.out.println(user_selected);
			final user user_to_be_added = new user();
			user_to_be_added.setId(1L);
			user_to_be_added.setName("小王");
			user_to_be_added.setSex("男");
			SQL_session.insert("mybatis_mapper.user-mapper.add_user", user_to_be_added);
			final user user_to_be_updated = new user();
			user_to_be_updated.setId(1L);
			user_to_be_updated.setName("老张");
			user_to_be_updated.setSex("女");
			SQL_session.update("mybatis_mapper.user-mapper.update_user", user_to_be_updated);
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
