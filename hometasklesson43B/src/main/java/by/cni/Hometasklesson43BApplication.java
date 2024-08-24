package by.cni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Hometasklesson43BApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hometasklesson43BApplication.class, args);
    }

}
