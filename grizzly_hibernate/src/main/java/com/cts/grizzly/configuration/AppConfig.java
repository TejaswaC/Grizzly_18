package com.cts.grizzly.configuration;

import java.util.Properties; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import static org.hibernate.cfg.Environment.*;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.cts.grizzly.dao"),
      @ComponentScan("com.cts.grizzly.service")})
public class AppConfig {

   @Autowired
   private Environment environment;

   @Bean("sessionFactory")
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

      Properties properties = new Properties();
      // Setting JDBC properties
      properties.put(DRIVER, environment.getProperty("mysql.driver"));
      properties.put(URL, environment.getProperty("mysql.url"));
      properties.put(USER, environment.getProperty("mysql.user"));
      properties.put(PASS, environment.getProperty("mysql.password"));

      // Setting Hibernate properties
      properties.put(SHOW_SQL, environment.getProperty("hibernate.show_sql"));
      properties.put(HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));

      // Setting C3P0 properties
      properties.put(C3P0_MIN_SIZE, 
            environment.getProperty("hibernate.c3p0.min_size"));
      properties.put(C3P0_MAX_SIZE, 
            environment.getProperty("hibernate.c3p0.max_size"));
      properties.put(C3P0_ACQUIRE_INCREMENT,
            environment.getProperty("hibernate.c3p0.acquire_increment"));
      properties.put(C3P0_TIMEOUT, 
            environment.getProperty("hibernate.c3p0.timeout"));
      properties.put(C3P0_MAX_STATEMENTS, 
            environment.getProperty("hibernate.c3p0.max_statements"));

      factoryBean.setHibernateProperties(properties);
     factoryBean.setPackagesToScan("com.cts.grizzly.bean");
      return factoryBean;
   }

   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
   }
}
