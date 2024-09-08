import factory.AbstractFactory;
import frame.FrameService;
import lombok.Data;
import lombok.ToString;
import saddle.SaddleService;
import wheels.WheelsService;

@Data
@ToString
public class BicycleService {

    public Bicycle createBicycle(AbstractFactory abstractFactory){
        FrameService frameService = abstractFactory.frameService();
        SaddleService saddleService = abstractFactory.saddleService();
        WheelsService wheelsService = abstractFactory.wheelsService();

        return new Bicycle(frameService.create(), saddleService.create(), wheelsService.create());
    }
}
