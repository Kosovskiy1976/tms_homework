package saddle.Impl;

import saddle.Saddle;
import saddle.SaddleService;

public class ForceSaddleServiceImpl implements SaddleService {
    @Override
    public Saddle create() {
        return new Saddle("Force");
    }
}
