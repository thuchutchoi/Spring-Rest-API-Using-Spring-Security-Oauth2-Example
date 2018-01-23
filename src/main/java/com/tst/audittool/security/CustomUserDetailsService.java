package com.tst.audittool.security;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tps.device_management.entities.UserInfo;
import com.tps.device_management.services.UserInfoService;

<<<<<<< HEAD:src/main/java/com/tps/device_management/security/CustomUserDetailsService.java
=======
import com.tst.audittool.entities.UserInfo;
import com.tst.audittool.services.UserInfoService;

>>>>>>> 1138b019bb2932d25f8072e62628b4c917506274:src/main/java/com/tst/audittool/security/CustomUserDetailsService.java
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired
	private UserInfoService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
<<<<<<< HEAD:src/main/java/com/tps/device_management/security/CustomUserDetailsService.java
		UserInfo user = userService.findUserInfoByUsername(username);
=======
		UserInfo user = userService.findByUsername(username);
>>>>>>> 1138b019bb2932d25f8072e62628b4c917506274:src/main/java/com/tst/audittool/security/CustomUserDetailsService.java
		logger.info("User : {}", user);
		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
				true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(UserInfo user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().getRoleName()));
		logger.info("authorities : {}", authorities);
		return authorities;
	}
}
