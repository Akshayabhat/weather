package io.egen.weather_spring_rest.api;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value="classpath:application.properties")

public class JPAConfig {
	
	@Autowired
	private Environment env;
	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	em.setDataSource(getDataSource());
	em.setPackagesToScan("io.egen.weather_spring_rest.api.entity");
	em.setJpaProperties(jpaProperties());
	return em;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.user","root"));
		ds.setPassword(env.getProperty("db.password","14494"));
		
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager txnMgr(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	private Properties jpaProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show.sql"));	
		props.setProperty("hibernate.format_sql", env.getProperty("hibernate.format.sql"));
		return props;
		
	}
}


