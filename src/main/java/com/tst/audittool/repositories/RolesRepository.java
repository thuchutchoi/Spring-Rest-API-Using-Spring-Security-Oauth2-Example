package com.tst.audittool.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tst.audittool.entities.UserRole;

public interface RolesRepository extends CrudRepository<UserRole, Integer> {

	/**
	 * This method using to ....
	 *
	 * @param role
	 * @return
	 */
	UserRole findByRoleName(String role);
}
