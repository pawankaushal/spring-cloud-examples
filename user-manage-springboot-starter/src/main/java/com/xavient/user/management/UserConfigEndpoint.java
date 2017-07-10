package com.xavient.user.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xavient.user.pojo.User;

@ConditionalOnClass(User.class)
@EnableConfigurationProperties(UserProperties.class)
@RestController
@RequestMapping("/user")
public class UserConfigEndpoint {
	
	@Autowired
	UserRepo repo;

	@GetMapping("/sample")
	public User getSample()
	{
		return new User(67,"fjfjf","hhfhf");
	}
	
	@GetMapping("/find/{name}")
	public User getUser(@PathVariable String name)
	{
		return repo.findByName(name);
	}
	
	@PostMapping("/new")
	public Boolean addUser(@RequestBody User user)
	{
		repo.save(user);
		return Boolean.TRUE;
	}
	
	@PutMapping("/update/{name}")
	public Boolean updateUser(@RequestBody User updatedUser)
	{
		User user = repo.findByName(updatedUser.getName()); 
		repo.delete(user);
		repo.save(updatedUser);
		return Boolean.TRUE;
	}
	
	@DeleteMapping("/delete/{name}")
	public Boolean deleterUser(@PathVariable String name)
	{
		repo.delete(repo.findByName(name));
		return Boolean.TRUE;
	}
}
