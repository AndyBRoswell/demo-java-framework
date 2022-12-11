package persistence;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface user_mapper {
	user select_user_by_id(Long id);
	List<user> select_all_users();
	int add_user(user user);
	int update_user(user user);
	int delete_user(Long id);
	int clear_users();
}
