package com.tps.device_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tps.device_management.entities.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

  UserInfo findByUsername(String username);
}
