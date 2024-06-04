package com.yedam.app.aop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableTransactionManagement
public class DBconfig {
		
//	@Bean
//	TransactionManager transactionManger(DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}
	
}
