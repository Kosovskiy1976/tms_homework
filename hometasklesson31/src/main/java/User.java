import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class User {

    public Integer wallet;

    public User(Integer wallet) {
        this.wallet = wallet;
    }
}
