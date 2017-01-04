package com.cmos.framework.mvp;


import android.view.View;

public interface V<T extends P> {
    void setPresenter(T presenter);

    View view();

    void onBind();

    void onUnbind();
}
