package com.cmos.framework.mvp.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cmos.framework.mvp.Pr;
import com.cmos.framework.mvp.Vu;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
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
        MainPresenter.create(new MainView(this, findViewById(R.id.activity_main))).start();
    }

    private void aaa() {
        startActivity(new Intent());
        startService(new Intent());
    }
}

class MainPresenter extends Pr<Contract.View> implements Contract.Presenter {
    public static Contract.Presenter create(Contract.View view) {
        return new MainPresenter(view);
    }

    public MainPresenter(Contract.View view) {
        super(view);
    }

    @Override
    public void hello() {
        Log.e("MainPresenter", mView.getTestText());
    }
}

class MainView extends Vu<Contract.Presenter> implements Contract.View {
    @BindView(R.id.test)
    TextView mTest;

    protected MainView(Activity context, View rootView) {
        super(context, rootView);
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
}
