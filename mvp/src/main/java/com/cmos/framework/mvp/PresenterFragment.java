package com.cmos.framework.mvp;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class PresenterFragment<T extends V> extends Fragment implements P {
    protected T v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = onCreateView(getActivity(), container);
        return v.view();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v.setPresenter(this);
        v.onBind();
        onBindView();
    }

    @Override
    public void onDestroyView() {
        v.onUnbind();
        super.onDestroyView();
        v = null;
    }

    protected void onBindView() {

    }

    protected abstract T onCreateView(Context context, ViewGroup parent);

}
