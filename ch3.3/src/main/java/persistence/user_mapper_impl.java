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
	public user select_user_by_id(final Long id) {
		return getSqlSession().selectOne(MyBatis_prefix + "select_user_by_id", id);
	}
	@Override
	public List<user> select_all_users() {
		return getSqlSession().selectList(MyBatis_prefix + "select_all_users");
	}
	@Override
	public int add_user(final user user) {
		return getSqlSession().insert(MyBatis_prefix + "add_user", user);
	}
	@Override
	public int update_user(final user user) {
		return getSqlSession().update(MyBatis_prefix + "update_user", user);
	}
	@Override
	public int delete_user(final Long id) {
		return getSqlSession().delete(MyBatis_prefix + "delete_user", id);
	}
	@Override
	public int clear_users() {
		return getSqlSession().delete(MyBatis_prefix + "clear_users");
	}
	@Override
	public List<user> MySQL_select_users_by_map(final Map<String, Object> param) {
		return getSqlSession().selectList(MyBatis_prefix + "MySQL_select_users_by_map", param);
	}
	@Override
	public List<user> MySQL_select_users_by_bean(final user user) {
		return getSqlSession().selectList(MyBatis_prefix + "MySQL_select_users_by_bean", user);
	}
	@Override
	public List<user> MySQL_select_users_by_param_annotation(final String name, final String sex) {
		final user user = new user();
		user.setName(name);
		user.setSex(sex);
		return getSqlSession().selectList(MyBatis_prefix + "MySQL_select_users_by_param_annotation", user);
	}
	@Override
	public int add_user_with_auto_increment(final user user) {
		return getSqlSession().insert(MyBatis_prefix + "add_user_with_auto_increment", user);
	}
	@Override
	public int add_user_with_custom_primary_key(final user user) {
		return getSqlSession().insert(MyBatis_prefix + "add_user_with_custom_primary_key", user);
	}
}
