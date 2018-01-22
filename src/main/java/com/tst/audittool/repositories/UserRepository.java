package com.tps.device_management.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tps.device_management.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * This method using to ....
	 *
	 * @param username
	 * @return
	 */
	@Query("FROM User u where u.username = ?1 AND u.isDeleted = false")
	User findByUsername(String username);

	/**
	 * This method using to ....
	 *
	 * @param username
	 * @return
	 */
	@Query("FROM User u where u.username = :username AND u.isDeleted = :true")
	User findByUsernameIsDeleted(String username);

	/**
	 * This method using to ....
	 *
	 * @param date
	 * @return
	 */
	@Query("FROM User u where u.isDeleted = :false AND u.updatedAt = :date ORDER BY u.createdAt ASC")
	List<User> getListUserByDate(Date date);

}
