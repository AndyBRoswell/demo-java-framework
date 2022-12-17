package persistence;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class user_mapper_impl extends base_mapper implements user_mapper {
	@Override
	public user select_user_by_id(Long id) {
		final SqlSession SQL_session = getSqlSession();
		return SQL_session.selectOne("persistence.user_mapper.select_user_by_id");
	}
	@Override
	public List<user> select_all_users() {
		final SqlSession SQL_session = getSqlSession();
		return SQL_session.selectList("persistence.user_mapper.select_all_users");
	}
	@Override
	public int add_user(user user) {
		return 0;
	}
	@Override
	public int update_user(user user) {
		return 0;
	}
	@Override
	public int delete_user(Long id) {
		return 0;
	}
	@Override
	public int clear_users() {
		return 0;
	}
}
