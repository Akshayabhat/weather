package io.egen.weather_spring_rest.api;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class JPAConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf(){
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	em.setDataSource(getDataSource());
	em.setPackagesToScan("io.egen.weather_spring_rest.api.entity");
	em.setJpaProperties(jpaProperties());
	return em;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource(){
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/example");
		ds.setUsername("root");
		ds.setPassword("14494");
		
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager txnMgr(EntityManagerFactory emf)
	{
		return new JpaTransactionManager(emf);
	}

	private Properties jpaProperties(){
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.hbm2ddl.auto", "validate");
		props.setProperty("hibernate.show_sql", "true");	
		props.setProperty("hibernate.format_sql", "true");
		return props;
		
	}
}


