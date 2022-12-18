package persistence;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface user_mapper {
	user select_user_by_id(final Long id);
	List<user> select_all_users();
	int add_user(final user user);
	int update_user(final user user);
	int delete_user(final Long id);
	int clear_users();
	List<user> MySQL_select_users_by_map(final Map<String, Object> param);
	List<user> MySQL_select_users_by_bean(final user user);
	List<user> MySQL_select_users_by_param_annotation(@Param("p_name") final String name, @Param("p_sex") final String sex);
	int add_user_with_auto_increment(final user user);
	int add_user_with_custom_primary_key(final user user);
}
