package frame.Impl;

import frame.Frame;
import frame.FrameService;

public class GiantFrameServiceImpl implements FrameService {
    @Override
    public Frame create() {
        return new Frame("Giant");
    }
}
