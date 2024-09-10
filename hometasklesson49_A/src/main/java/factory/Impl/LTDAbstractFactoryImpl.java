package factory.Impl;

import factory.AbstractFactory;
import frame.FrameService;
import frame.Impl.LTDFrameServiceImpl;
import saddle.Impl.ForceSaddleServiceImpl;
import saddle.SaddleService;
import wheels.Impl.KENDAWheelsServiceImpl;
import wheels.WheelsService;

public class LTDAbstractFactoryImpl implements AbstractFactory {
    @Override
    public FrameService frameService() {
        return new LTDFrameServiceImpl();
    }

    @Override
    public SaddleService saddleService() {
        return new ForceSaddleServiceImpl();
    }

    @Override
    public WheelsService wheelsService() {
        return new KENDAWheelsServiceImpl();
    }
}
