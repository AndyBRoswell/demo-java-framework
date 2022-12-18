package persistence;

import java.util.List;

public interface person_mapper {
	person select_person_by_id_1(final Long id);
	person select_person_by_id_2(final Long id);
	List<person> select_all_persons();
	int add_person(final person person);
	int add_person_with_auto_increment(final person person);
	int update_person(final person person);
	int delete_person(final Long id);
}
