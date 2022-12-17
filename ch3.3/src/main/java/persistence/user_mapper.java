package persistence;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface user_mapper {
	user select_user_by_id(Long id);
	List<user> select_all_users();
	int add_user(user user);
	int update_user(user user);
	int delete_user(Long id);
	int clear_users();
	List<user> MySQL_select_users_by_map(Map<String, Object> param);
	List<user> MySQL_select_users_by_bean(user user);
	List<user> MySQL_select_users_by_param_annotation(@Param("p_name") String name, @Param("p_sex") String sex);
}
