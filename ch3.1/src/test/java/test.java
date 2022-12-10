import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import persistence.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
	public static void main(String[] args) {
		try {
			final InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			final SqlSessionFactory SQL_session_factory = new SqlSessionFactoryBuilder().build(config);
			final SqlSession SQL_session = SQL_session_factory.openSession();
			final user user_selected = SQL_session.selectOne("mybatis_mapper.user-mapper.select_user_by_id", 1);
			System.out.println(user_selected);
			final user user_to_be_added = new user();
			user_to_be_added.setId(2L);
			user_to_be_added.setName("小王");
			user_to_be_added.setSex("男");
			SQL_session.insert("mybatis_mapper.user-mapper.add_user", user_to_be_added);
			final user user_to_be_updated = new user();
			user_to_be_updated.setId(1L);
			user_to_be_updated.setName("老张");
			user_to_be_updated.setSex("女");
			SQL_session.update("mybatis_mapper.user-mapper.update_user", user_to_be_updated);
			SQL_session.delete("mybatis_mapper.user-mapper.delete_user", 2);
			final List<user> user_list = SQL_session.selectList("mybatis_mapper.user-mapper.select_all_user");
			for (final user user : user_list) {
				System.out.println(user);
			}
			SQL_session.commit();
			SQL_session.close();
		}
		catch (IOException e) {e.printStackTrace();}
	}
}
