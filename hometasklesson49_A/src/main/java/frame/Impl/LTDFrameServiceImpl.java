package frame.Impl;

import frame.Frame;
import frame.FrameService;

public class LTDFrameServiceImpl implements FrameService {
    @Override
    public Frame create() {
        return new Frame("LTD");
    }
}
