package persistence;

public interface person_mapper {
	person select_person_by_id_1(final Long id);
	person select_person_by_id_2(final Long id);
	int add_person(final person person);
	int add_person_with_auto_increment(final person person);
	int update_person(final person person);
	int delete_person(final Long id);
}
