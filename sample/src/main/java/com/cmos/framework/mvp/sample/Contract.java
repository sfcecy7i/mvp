package com.cmos.framework.mvp.sample;


import com.cmos.framework.mvp.P;
import com.cmos.framework.mvp.V;

public interface Contract {
    interface Presenter extends P {

    }

    interface View extends V<Presenter> {

    }
}
