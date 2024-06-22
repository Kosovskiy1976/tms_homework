package by.cni;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "by.cni")
@EnableWebMvc
public class AppConfig {
    @Bean
    public SessionFactory sessionFactory(){
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration();
        Properties properties = new Properties();
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "Ichbin");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "create");
        cfg.addProperties(properties);
        cfg.addAnnotatedClass(PersonEntity.class);
        cfg.addAnnotatedClass(OrderEntity.class);
        return cfg.buildSessionFactory();
    }

}
