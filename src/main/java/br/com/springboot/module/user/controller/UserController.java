package br.com.springboot.module.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.module.user.dto.CreateUserRoleDTO;
import br.com.springboot.module.user.entities.User;
import br.com.springboot.module.user.services.CreateRoleUserService;
import br.com.springboot.module.user.services.CreateUserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  CreateUserService createUserService;

  @Autowired
  CreateRoleUserService createRoleUserService;
  
  @PostMapping("/create")
  public User create(@RequestBody User user) {
    return createUserService.execute(user);
  }

  @PostMapping("/role")
  public User role(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
    return createRoleUserService.execute(createUserRoleDTO);
  }

}