package wheels.Impl;

import wheels.Wheels;
import wheels.WheelsService;

public class CONTINENTALWheelsServiceImpl implements WheelsService {
    @Override
    public Wheels create() {
        return new Wheels("CONTINENTAL");
    }
}
