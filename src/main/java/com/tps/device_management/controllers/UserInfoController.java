package com.tps.device_management.controllers;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tps.device_management.entities.UserInfo;
import com.tps.device_management.services.UserInfoService;

/**
 * Handles requests for user info.
 */
@RestController
public class UserInfoController {

    final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserInfo> getUserInfoById(HttpServletRequest req, @PathVariable("id") Integer id) {
		logger.info("IN - getUserInfoById()");

		logger.info("OUT - getUserInfoById()");
		return userInfoService.findUserInfoById(req, id);
	}
}
