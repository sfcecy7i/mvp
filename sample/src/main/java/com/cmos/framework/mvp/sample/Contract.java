package com.cmos.framework.mvp.sample;


import com.cmos.framework.mvp.P;
import com.cmos.framework.mvp.V;

public interface Contract {
    interface Presenter extends P {
        void hello();
    }

    interface View extends V<Presenter> {
        String getTestText();
    }
}
