package DAO;

import entity.user;

import java.util.List;

public interface DAO {
	int update(String SQL, Object[] param);
	List<user> query(String SQL, Object[] param);
}
