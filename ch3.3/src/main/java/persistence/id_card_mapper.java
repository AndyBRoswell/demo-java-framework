package persistence;

import java.util.List;

public interface id_card_mapper {
	id_card select_code_by_id(final Long id);
	List<id_card> select_all_id_cards();
	int add_id_card(final id_card id_card);
	int add_id_card_with_auto_increment(final id_card id_card);
	int update_id_card(final id_card id_card);
	int delete_id_card(final Long id);
}
