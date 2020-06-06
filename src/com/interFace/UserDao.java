package com.interFace;

import java.util.List;
import com.dao.entity.UserEntity;

public interface UserDao {
	List<UserEntity> fetchAll() throws Exception;
	String updateUser(UserEntity entity) throws Exception;
	String addUser(UserEntity entity) throws Exception;
	String deleteUser(String name);
	

}
