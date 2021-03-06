package com.tst.audittool.security;
// package com.tps.device_management.security;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.authentication.AuthenticationTrustResolver;
// import
// org.springframework.security.authentication.AuthenticationTrustResolverImpl;
// import
// org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
//
// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
// @Autowired
// @Qualifier("customUserDetailsService")
// UserDetailsService userDetailsService;
//
// @Autowired
// public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws
// Exception {
// auth.userDetailsService(userDetailsService);
// auth.authenticationProvider(authenticationProvider());
// }
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http.csrf().disable();
// http.authorizeRequests().antMatchers("/users/**").access("hasRole('ADMIN')").antMatchers("/home")
// .access("hasRole('ADMIN')").antMatchers("/courses/**").access("hasRole('ADMIN')")
// .antMatchers("/course/**").access("hasRole('ADMIN')");
//
// http.authorizeRequests().and().formLogin().loginProcessingUrl("/login").loginPage("/login")
// .defaultSuccessUrl("/students").failureUrl("/login?fail=true").usernameParameter("username")
// .passwordParameter("password").and().logout().logoutUrl("/logout?logout=true")
// .logoutSuccessUrl("/login").and().exceptionHandling().accessDeniedPage("/login?permission=true");
// }
//
// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }
//
// @Bean
// public DaoAuthenticationProvider authenticationProvider() {
// DaoAuthenticationProvider authenticationProvider = new
// DaoAuthenticationProvider();
// authenticationProvider.setUserDetailsService(userDetailsService);
// authenticationProvider.setPasswordEncoder(passwordEncoder());
// return authenticationProvider;
// }
//
// @Bean
// public AuthenticationTrustResolver getAuthenticationTrustResolver() {
// return new AuthenticationTrustResolverImpl();
// }
//
// }
