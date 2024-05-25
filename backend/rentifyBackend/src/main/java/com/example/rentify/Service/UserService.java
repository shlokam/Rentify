package com.example.rentify.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentify.Entity.UserEntity;
import com.example.rentify.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public UserEntity saveUser(UserEntity user) {
    	UserEntity checkIfUserEmailExists  = findByEmail(user.getEmail());
    	if(checkIfUserEmailExists!=null)
    		return null;
        return userRepository.addUser(user);
    }
    
    public List<UserEntity> getAllUser(){
    	return userRepository.getUserEntityDatabase();
    }

	public UserEntity findByEmail(String email) {
		// TODO Auto-generated method stub
		
		List<UserEntity> listOfUserEntity = userRepository.getUserEntityDatabase();
		
		for(UserEntity entity : listOfUserEntity) {
			if(entity.getEmail().equals(email)) {
				return entity;
			}
		}
		return null;
	}
}
