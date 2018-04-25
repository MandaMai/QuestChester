package com.questchester.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.questchester.message.Response;
import com.questchester.model.User;
import com.questchester.repo.UserRepository;
 
@RestController
public class UserController {
 
	@Autowired
	UserRepository repository;
 
	@RequestMapping(value = "/postuser", method = RequestMethod.POST)
	public void postUser(@RequestBody User user) {
		repository.save(new User(user.getFirstName(), user.getLastName(), user.getAddress(), 
				user.getCity(), user.getState(), user.getZipCode(), user.getEmail(), 
				user.getPassword(), user.getPhone(), user.getLevel(), user.getNickname()));
	}
 
	@RequestMapping("/findall")
	public Response findAll() {
		Iterable<User> users = repository.findAll();
		return new Response("Done", users);
	}
 
	@RequestMapping("/user/{id}")
	public Response findCustomerById(@PathVariable("id") long id) {
		Optional<User> user = repository.findById(id);
		return new Response("Done", user);
	}
 
	@RequestMapping("/findbylastname")
	public Response findByLastName(@RequestParam("lastName") String lastName) {
		List<User> users = repository.findByLastName(lastName);
		return new Response("Done", users);
	}
}
