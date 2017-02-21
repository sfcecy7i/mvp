package com.cmos.framework.mvp.sample.test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cmos.framework.mvp.Pr;
import com.cmos.framework.mvp.sample.Contract;
import com.cmos.framework.mvp.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Contract.View {
    Contract.Presenter mPresenter;
    @BindView(R.id.test)
    TextView mTest;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Toast.makeText(this, "onActivityResult", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainPresenter.create(this);
        mTest.setText("Hello, mvp");
        mTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.hello();
            }
        });
    }

    @Override
    public String getTestText() {
        return mTest.getText().toString();
    }

    @Override
    public void bindPresenter(Contract.Presenter presenter) {
        mPresenter = presenter;
    }
}

class MainPresenter extends Pr<Contract.View> implements Contract.Presenter {
    public static void create(Contract.View view) {
        new MainPresenter(view);
    }

    public MainPresenter(Contract.View view) {
        super(view);
    }

    @Override
    public void hello() {
        Log.e("MainPresenter", mView.getTestText());
    }
}
