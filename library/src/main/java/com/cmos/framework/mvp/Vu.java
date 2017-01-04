package com.cmos.framework.mvp;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class Vu<T extends P> implements V<T> {
    protected T p;
    private View mView;
    protected Context mContext;

    protected Vu(Context context, ViewGroup parent) {
        this.mContext = context;
        mView = LayoutInflater.from(context).inflate(xml(), parent, false);
        ButterKnife.bind(this, mView);
    }

    @LayoutRes
    protected abstract int xml();

    @Override
    public void setPresenter(T presenter) {
        this.p = presenter;
    }

    @Override
    public View view() {
        return mView;
    }
}
