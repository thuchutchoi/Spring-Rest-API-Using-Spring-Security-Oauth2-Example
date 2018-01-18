/**
 * File Name  : PersistenceContext.java
 * Package    : com.tps.device_management.configuration
 * Author     : nghiant
 * Created    : Jan 7, 2018

 * This source code is part of the  device-management, and is copyrighted by TPS.
 * All rights reserved.  No part of this work may be reproduced, stored in a retrieval system,
 * adopted or transmitted in any form or by any means,electronic, mechanical, photographic,
 * graphic, optic recording or otherwise,translated in any language or computer language,
 * without the prior written permission of TPS

Copyright © 2018 by TPS
 */
package com.tps.device_management.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author nghiant This class using for config for layer persistence.
 */
@EnableJpaRepositories(basePackages = { "com.tps.device_management.repositories" })
@EnableTransactionManagement
@Configuration
// @PropertySource("classpath:application.properties")
@PropertySource(value = { "classpath:application.properties" })
public class PersistenceContext {
	@Autowired
	private Environment environment;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(environment.getProperty("db.driver"));
		dataSourceConfig.setJdbcUrl(environment.getProperty("db.url"));
		dataSourceConfig.setUsername(environment.getProperty("db.username"));
		dataSourceConfig.setPassword(environment.getProperty("db.password"));
		return new HikariDataSource(dataSourceConfig);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.tps.device_management.entities");
		Properties jpaProperties = new Properties();
		// Configures the used database dialect. This allows Hibernate to create
		// SQL
		// that is optimized for the used database.
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		// If the value of this property is true, Hibernate writes all SQL
		// statements to the console.
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		// If the value of this property is true, Hibernate will format the SQL
		// that is written to the console.
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
