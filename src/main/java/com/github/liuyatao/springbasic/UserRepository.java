package com.github.liuyatao.springbasic;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */

 @Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUserName(String userName);

}