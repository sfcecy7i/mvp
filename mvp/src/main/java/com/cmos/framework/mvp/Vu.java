package com.cmos.framework.mvp;


import android.app.Activity;
import android.view.View;

import butterknife.ButterKnife;

public abstract class Vu<T extends P> implements V<T> {
    protected View mRootView;
    protected Activity mContext;
    protected T mPresenter;

    protected Vu(Activity context, View rootView) {
        this.mContext = context;
        this.mRootView = rootView;
        ButterKnife.bind(this, rootView);
    }

    @Override
    public void bindPresenter(T presenter) {
        this.mPresenter = presenter;
        onBind();
    }

    @Override
    public void onBind() {
    }
}
