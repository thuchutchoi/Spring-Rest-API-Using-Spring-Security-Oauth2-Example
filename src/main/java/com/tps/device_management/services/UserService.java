package com.tps.device_management.services;

import java.util.Date;
import java.util.List;

import com.tps.device_management.entities.Roles;
import com.tps.device_management.entities.User;
public interface UserService {

	User findById(int id);

	User findByUsername(String username);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserByUsername(String username);

	List<User> findAllUsers();

	List<Roles> getRoles();

	boolean isUserUsernameUnique(Integer id, String username);

	List<User> getListUserByDate(Date date);

	Roles findRoleByRoleName(String role);


	Roles findRoleByRoleId(int parseInt);

	User findByUsernameIsDeleted(String username);

}
