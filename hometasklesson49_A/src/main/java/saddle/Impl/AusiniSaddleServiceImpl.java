package saddle.Impl;

import saddle.Saddle;
import saddle.SaddleService;

public class AusiniSaddleServiceImpl implements SaddleService {
    @Override
    public Saddle create() {
        return new Saddle("Ausini");
    }
}
