//package ru.kpfu.bookstore.config;
//
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
////@ComponentScan(basePackages = {"ru.kpfu.bookstore.dao", "ru.kpfu.bookstore.model", "ru.kpfu.bookstore.service"})
////@PropertySource("classpath:/app.properties")
////@EnableTransactionManagement
//public class RootConfig {
//
////  @Autowired
////  private Environment env;
////
////  @Bean
////  public DataSource dataSource() {
////    DriverManagerDataSource dataSource = new DriverManagerDataSource();
////    dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
////    dataSource.setUrl(env.getProperty("jdbc.uri"));
////    dataSource.setUsername(env.getProperty("db.username"));
////    dataSource.setPassword(env.getProperty("db.password"));;
////    return dataSource;
////  }
//}
