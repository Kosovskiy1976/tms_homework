package by.cni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "by.cni.client")
public class Hometasklesson53Application {

    public static void main(String[] args) {
        SpringApplication.run(Hometasklesson53Application.class, args);
    }

}
