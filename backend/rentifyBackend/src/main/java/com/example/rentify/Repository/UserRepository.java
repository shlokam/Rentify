package com.example.rentify.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.rentify.Entity.UserEntity;

@Repository
public class UserRepository {
	
	List<UserEntity> userEntityDatabase = new ArrayList<UserEntity>();
	
	public UserEntity addUser(UserEntity userEntity) {
		userEntity.setId(System.currentTimeMillis());
		userEntityDatabase.add(userEntity);
		return userEntity;
	}

	public List<UserEntity> getUserEntityDatabase() {
		return userEntityDatabase;
	}
	
}
