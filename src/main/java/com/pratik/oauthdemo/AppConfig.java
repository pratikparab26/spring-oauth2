package com.pratik.oauthdemo;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
public class AppConfig {
	

	@Value("${spring.datasource.url}")
	private String dataSourceUrl;
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriverClassName;
	@Value("${spring.datasource.username}")
	private String dbUsername;
	@Value("${spring.datasource.password}")
	private String dbPassword;

	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbDriverClassName);
		dataSource.setUrl(dataSourceUrl);

		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);

		return dataSource;

	}

	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource());
	}
	

}
