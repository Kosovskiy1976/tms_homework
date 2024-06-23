package by.cni;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter

public class User {

    public Integer wallet;

    public User(Integer wallet) {
        this.wallet = wallet;
    }
}
