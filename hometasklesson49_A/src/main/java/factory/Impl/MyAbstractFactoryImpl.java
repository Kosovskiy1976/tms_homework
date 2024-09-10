package factory.Impl;

import factory.AbstractFactory;
import frame.FrameService;
import frame.Impl.LTDFrameServiceImpl;
import saddle.Impl.AusiniSaddleServiceImpl;
import saddle.SaddleService;
import wheels.Impl.CONTINENTALWheelsServiceImpl;
import wheels.WheelsService;

public class MyAbstractFactoryImpl implements AbstractFactory {
    @Override
    public FrameService frameService() {
        return new LTDFrameServiceImpl();
    }

    @Override
    public SaddleService saddleService() {
        return new AusiniSaddleServiceImpl();
    }

    @Override
    public WheelsService wheelsService() {
        return new CONTINENTALWheelsServiceImpl();
    }
}
