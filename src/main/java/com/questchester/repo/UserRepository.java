package com.questchester.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
 
import com.questchester.model.User;
 
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByLastName(String lastName);
}
