package com.cmos.framework.mvp.sample;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cmos.framework.mvp.PresenterActivity;
import com.cmos.framework.mvp.Vu;

import butterknife.BindView;

public class MainActivity extends PresenterActivity<Contract.View> implements Contract.Presenter {
    @Override
    protected Contract.View onCreateView(Context context, ViewGroup parent) {
        return MainView.create(context, parent);
    }
}

class MainView extends Vu<Contract.Presenter> implements Contract.View {
    @BindView(R.id.test)
    TextView mTest;

    private MainView(Context context, ViewGroup parent) {
        super(context, parent);
    }

    @Override
    protected int xml() {
        return R.layout.activity_main;
    }

    @Override
    public void onBind() {
        mTest.setText("Hello, MVP.");
    }

    @Override
    public void onUnbind() {

    }

    static Contract.View create(Context context, ViewGroup parent) {
        return new MainView(context, parent);
    }
}
