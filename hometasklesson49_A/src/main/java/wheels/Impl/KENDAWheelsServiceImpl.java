package wheels.Impl;

import wheels.Wheels;
import wheels.WheelsService;

public class KENDAWheelsServiceImpl implements WheelsService {
    @Override
    public Wheels create() {
        return new Wheels("KENDA");
    }
}
