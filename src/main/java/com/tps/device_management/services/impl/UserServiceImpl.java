package com.tps.device_management.services.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tps.device_management.entities.Roles;
import com.tps.device_management.entities.User;
import com.tps.device_management.repositories.RolesRepository;
import com.tps.device_management.repositories.UserRepository;
import com.tps.device_management.services.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public User findById(int id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public User findByUsername(String username) {
		User user = this.userRepository.findByUsername(username);
		return user;
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.userRepository.save(user);
	}

	@Override
	public List<Roles> getRoles() {
		return (List<Roles>) this.rolesRepository.findAll();
	}

	@Override
	public void updateUser(User user) {
		this.userRepository.save(user);
	}

	@Override
	public void deleteUserByUsername(String username) {
		User findByUsername = findByUsername(username);
		this.userRepository.delete(findByUsername);
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) this.userRepository.findAll();
	}

	@Override
	public boolean isUserUsernameUnique(Integer id, String username) {
		User user = findByUsername(username);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	public List<User> getListUserByDate(Date date) {
		return this.userRepository.getListUserByDate(date);
	}

	@Override
	public Roles findRoleByRoleName(String role) {
		return this.rolesRepository.findRoleByRoleName(role);
	}

	@Override
	public Roles findRoleByRoleId(int parseInt) {
		return this.rolesRepository.findOne(parseInt);
	}

	@Override
	public User findByUsernameIsDeleted(String username) {
		User user = this.userRepository.findByUsernameIsDeleted(username);
		return user;
	}

}
