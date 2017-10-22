package com.lytech.xvjialing.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.btn_helloWorld)
    Button btnHelloWorld;
    @BindView(R.id.btn_signal)
    Button btnSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_helloWorld, R.id.btn_signal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_helloWorld:
                startActivity(new Intent(this,HelloWorldActivity.class));
                break;
            case R.id.btn_signal:
                startActivity(new Intent(this,SignalActivity.class));
                break;
        }
    }
}
