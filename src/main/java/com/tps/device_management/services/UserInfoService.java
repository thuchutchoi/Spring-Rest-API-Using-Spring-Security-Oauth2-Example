package com.tps.device_management.services;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import com.tps.device_management.entities.UserInfo;
public interface UserInfoService {

	/**
     * Get UserInfo by id
     *
     * @param req HttpServletRequest
     * @param id BillingAccount id
     * @return the response entity <br>
     *         200: OK.<br>
     *         400: Bad Request.<br>
     *         404: Not found.<br>
     */
	public ResponseEntity<UserInfo> findUserInfoById(HttpServletRequest req, int id);

	/**
	 * Get UserInfo by username
	 *
	 * @param username
	 * @return UserInfo
	 */
	UserInfo findUserInfoByUsername(String username);
}
