package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

}
