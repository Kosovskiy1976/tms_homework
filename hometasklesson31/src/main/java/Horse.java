import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@RequiredArgsConstructor
public class Horse {

    public Integer finishTime;
    public final Integer horseNumber;

}
