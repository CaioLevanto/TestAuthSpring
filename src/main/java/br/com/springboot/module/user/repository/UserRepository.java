package br.com.springboot.module.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.springboot.module.user.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

  User findByUsername(String username);

  @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username")
  User findByUsernameFetchRoles(@Param("username") String username);

}