package factory;

import frame.FrameService;
import saddle.SaddleService;
import wheels.WheelsService;

public interface AbstractFactory {

    FrameService frameService();

    SaddleService saddleService();

    WheelsService wheelsService();
}
