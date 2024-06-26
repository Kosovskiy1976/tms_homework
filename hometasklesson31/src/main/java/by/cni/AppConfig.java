package by.cni;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "by.cni")
public class AppConfig {

    @Bean
    public User user() {
        return new User(0);}

    @Bean
    public Horse horse1() {
        return new Horse(1);
    }

    @Bean
    public Horse horse2() {
        return new Horse(2);
    }

    @Bean
    public Horse horse3() {
        return new Horse(3);
    }

    @Bean
    public Horse horse4() {
        return new Horse(4);
    }

    @Bean
    public Horse horse5() {
        return new Horse(5);
    }

}
