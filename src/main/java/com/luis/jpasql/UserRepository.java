package com.luis.jpasql;

import org.springframework.data.repository.CrudRepository;
import com.luis.jpasql.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}