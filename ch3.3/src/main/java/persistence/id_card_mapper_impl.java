package persistence;

import java.util.List;

public class id_card_mapper_impl extends base_mapper implements id_card_mapper {
	private static final String MyBatis_prefix = "persistence.id_card_mapper.";
	@Override
	public id_card select_code_by_id(final Long id) {
		return getSqlSession().selectOne(MyBatis_prefix + "select_code_by_id");
	}
	@Override
	public List<id_card> select_all_id_cards() {
		return getSqlSession().selectList(MyBatis_prefix + "select_all_id_cards");
	}
	@Override
	public int add_id_card(final id_card id_card) {
		return getSqlSession().insert(MyBatis_prefix + "add_id_card", id_card);
	}
	@Override
	public int add_id_card_with_auto_increment(id_card id_card) {
		return getSqlSession().insert(MyBatis_prefix + "add_id_card_with_auto_increment", id_card);
	}
	@Override
	public int update_id_card(final id_card id_card) {
		return getSqlSession().update(MyBatis_prefix + "update_id_card", id_card);
	}
	@Override
	public int delete_id_card(final Long id) {
		return getSqlSession().delete(MyBatis_prefix + "delete_id_card", id);
	}
}
