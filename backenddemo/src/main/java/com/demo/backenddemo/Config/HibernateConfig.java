package com.demo.backenddemo.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.demo.backenddemo.Model.Customer;



@Configuration
@ComponentScan({"com.demo.backenddemo"})
public class HibernateConfig {
	@Autowired
	@Bean(name="datasource")
	public DataSource dataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/detail");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}
	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.show_sql", "true");//not-a-must
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.format_sql", "true");//not-a-must		
		prop.put("hibernate.hbm2ddl.auto", "update");
		return prop;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.addAnnotatedClass(Customer.class);
/*		builder.addAnnotatedClass(Role.class);*/
		return builder.buildSessionFactory();
	}

}
