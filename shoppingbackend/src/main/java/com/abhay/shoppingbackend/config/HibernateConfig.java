package com.abhay.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.abhay.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshopping";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "1234";
	
	//dataSource bean will be available
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		//Database Connection Information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		
		
		return dataSource;
	}
	
	//sessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.abhay.shoppingbackend.dto");
	
		return builder.buildSessionFactory();
	}
	
	//All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", DATABASE_DIALECT);
		props.put("hibernate.show_sql","true");
		props.put("hibernate.format_sql","true");
		return props;
	}
	
	//transactionManager bean will be available
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	
}
