package com.cmos.framework.mvp;


public interface V<T extends P> {
    void bindPresenter(T presenter);

}
