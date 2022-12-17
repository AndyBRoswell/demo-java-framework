package persistence;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface user_mapper {
	user select_user_by_id(Long id);
	List<user> select_all_users();
	int add_user(user user);
	int update_user(user user);
	int delete_user(Long id);
	int clear_users();
	List<user> MySQL_select_user_by_map(Map<String, Object> param);
}
