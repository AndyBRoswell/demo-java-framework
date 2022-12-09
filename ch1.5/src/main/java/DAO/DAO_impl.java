package DAO;

import entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAO_impl implements DAO {
	@Autowired
	private JdbcTemplate JDBC_template;

	@Override
	public int update(String SQL, Object[] param) {
		return JDBC_template.update(SQL, param);
	}
	@Override
	public List<user> query(String SQL, Object[] param) {
		RowMapper<user> row_mapper = new BeanPropertyRowMapper<>(user.class);
		return JDBC_template.query(SQL, row_mapper);
	}
}
