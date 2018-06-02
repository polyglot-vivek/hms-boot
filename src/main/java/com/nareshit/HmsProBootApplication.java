package com.nareshit;

import java.util.concurrent.ThreadPoolExecutor;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class HmsProBootApplication implements CommandLineRunner{
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private HikariDataSource hds;
	
	public static void main(String[] args) {
		SpringApplication.run(HmsProBootApplication.class, args);
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	  return	new HibernateJpaSessionFactoryBean();
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("the deafult datasource is:\t"+ds);
		//System.out.println(ds.getConnection());
		System.out.println(hds.getMaximumPoolSize());
		System.out.println(hds.getMinimumIdle());
		System.out.println(hds.getConnectionTestQuery());
		System.out.println(hds.getConnection().getSchema());
		
		
		
		
	}
}
