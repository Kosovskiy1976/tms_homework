import frame.Frame;
import lombok.AllArgsConstructor;
import lombok.Data;
import saddle.Saddle;
import wheels.Wheels;

@Data
@AllArgsConstructor
public class Bicycle {

    Frame frame;
    Saddle saddle;
    Wheels wheels;
}
