package com.cmos.framework.mvp;


public abstract class Pr<T extends V> implements P<T> {
    protected T mView;

    public Pr(T view) {
        mView = view;
        mView.bindPresenter(this);
    }

    @Override
    public void register() {
    }

    @Override
    public void unregister() {
    }

    @Override
    public void start() {
        mView.onBind();
    }
}
