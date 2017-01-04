package com.cmos.framework.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

public abstract class PresenterActivity<T extends V> extends AppCompatActivity implements P {
    protected T v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = onCreateView(this, null);
        setContentView(v.view());
        v.setPresenter(this);
        v.onBind();
        onBindView();
    }

    @Override
    protected void onDestroy() {
        v.onUnbind();
        onDestroyView();
        v = null;
        super.onDestroy();
    }

    protected void onDestroyView() {

    }

    protected void onBindView() {

    }

    protected abstract T onCreateView(Context context, ViewGroup parent);

}
