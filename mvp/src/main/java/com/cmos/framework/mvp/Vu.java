package com.cmos.framework.mvp;


import android.app.Activity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class Vu<T extends P> implements V<T> {
    private final Unbinder mUnbinder;
    protected View mRootView;
    protected Activity mContext;
    protected T mPresenter;

    protected Vu(Activity context, View rootView) {
        this.mContext = context;
        this.mRootView = rootView;
        mUnbinder = ButterKnife.bind(this, rootView);
    }

    @Override
    public void bindPresenter(T presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onBind() {
    }

    @Override
    public void onUnbind() { // for fragment, call in onDestroyView
        mUnbinder.unbind();
    }
}
