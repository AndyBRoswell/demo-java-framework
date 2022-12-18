package persistence;

import java.util.List;

public class person_mapper_impl extends base_mapper implements person_mapper {
	private static final String MyBatis_prefix = "persistence.person_mapper.";

	@Override
	public person select_person_by_id_1(Long id) {
		return getSqlSession().selectOne(MyBatis_prefix + "select_person_by_id_1");
	}
	@Override
	public person select_person_by_id_2(Long id) {
		return getSqlSession().selectOne(MyBatis_prefix + "select_person_by_id_2");
	}
	@Override
	public List<person> select_all_persons() {
		return getSqlSession().selectList(MyBatis_prefix + "select_all_persons");
	}
	@Override
	public int add_person(person person) {
		return getSqlSession().insert(MyBatis_prefix + "");
	}
	@Override
	public int add_person_with_auto_increment(person person) {
		return 0;
	}
	@Override
	public int update_person(person person) {
		return 0;
	}
	@Override
	public int delete_person(Long id) {
		return 0;
	}
}
