package com.website.filmlist.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
/**
 * This is the class for the configuration of database
 * 
 * @author williammeilland
 *
 */
@PropertySource(value= {"classpath:application.properties"})
@Configuration
public class DBConfig {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;
	@Value("${spring.datasource.dbcp2.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.jpa.database-platform}")
	private String dialect;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource(url,username, password);
		dataSource.setDriverClassName(driverClass);
		return (DataSource) dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory= new LocalSessionFactoryBean();
		factory.setDataSource(this.getDataSource());
		factory.setHibernateProperties(this.hibernateProperties());
		factory.setPackagesToScan(new String[] { "com.website.filmlist.domain" });
		return factory;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(factory);
		return transactionManager;
	}
}
