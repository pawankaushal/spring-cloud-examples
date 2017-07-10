package com.xavient.user.management;

import org.springframework.data.repository.CrudRepository;

import com.xavient.user.pojo.User;

public interface UserRepo extends CrudRepository<User, Long>{
	User findByName(String name);

}
