package br.com.springboot.module.user.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.module.user.dto.CreateUserRoleDTO;
import br.com.springboot.module.user.entities.Role;
import br.com.springboot.module.user.entities.User;
import br.com.springboot.module.user.repository.UserRepository;

@Service
public class CreateRoleUserService {

  @Autowired
  UserRepository userRepository;

  public User execute(CreateUserRoleDTO createUserRoleDTO) {

    Optional<User> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
    List<Role> roles = new ArrayList<>();

    if (!userExists.isPresent()) {
      throw new Error("User does not exists!");
    }

    roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
      return new Role(role);
    }).collect(Collectors.toList());

    User user = userExists.get();

    user.setRoles(roles);

    userRepository.save(user);

    return user;

  }
}