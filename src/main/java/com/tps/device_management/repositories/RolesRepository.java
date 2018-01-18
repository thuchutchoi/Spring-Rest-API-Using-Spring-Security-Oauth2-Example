package com.tps.device_management.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tps.device_management.entities.Roles;

public interface RolesRepository extends CrudRepository<Roles, Integer> {

	/**
	 * This method using to ....
	 *
	 * @param role
	 * @return
	 */
	@Query("FROM Roles role where role.roleName = :role")
	Roles findRoleByRoleName(String role);
}
