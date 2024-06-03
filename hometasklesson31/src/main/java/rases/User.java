package rases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    public Integer wallet;

    public User(Integer wallet) {
        this.wallet = wallet;
    }
}
