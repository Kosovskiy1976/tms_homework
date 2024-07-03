package by.cni.hometasklesson38;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${app.name}")
    private String name;
    @Value("${app.surname}")
    private String surname;

    @PostConstruct
    public void test(){
        System.out.println(name);
        System.out.println(surname);
    }
}
