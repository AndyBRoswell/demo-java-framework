package persistence;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class user_mapper_impl extends base_mapper implements user_mapper {
	private static final String MyBatis_prefix = "persistence.user_mapper.";
	@Override
	public user select_user_by_id(Long id) {
		final SqlSession SQL_session = getSqlSession();
		return SQL_session.selectOne(MyBatis_prefix + "select_user_by_id", id);
	}
	@Override
	public List<user> select_all_users() {
		final SqlSession SQL_session = getSqlSession();
		return SQL_session.selectList(MyBatis_prefix + "select_all_users");
	}
	@Override
	public int add_user(user user) {
		final SqlSession SQL_session = getSqlSession();
		return SQL_session.insert(MyBatis_prefix + "add_user", user);
	}
	@Override
	public int update_user(user user) {
		final SqlSession SQL_session = getSqlSession();
		return SQL_session.update(MyBatis_prefix + "update_user", user);
	}
	@Override
	public int delete_user(Long id) {
		final SqlSession SQL_session = getSqlSession();
		return SQL_session.delete(MyBatis_prefix + "delete_user", id);
	}
	@Override
	public int clear_users() {
		final SqlSession SQL_session = getSqlSession();
		return SQL_session.delete(MyBatis_prefix + "clear_users");
	}
	@Override
	public List<user> MySQL_select_user_by_map(Map<String, Object> param) {
		final SqlSession SQL_session = getSqlSession();
		return SQL_session.selectList(MyBatis_prefix + "MySQL_select_user_by_map", param);
	}
}
