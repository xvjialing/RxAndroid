package com.lytech.xvjialing.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class SignalActivity extends AppCompatActivity {

    private static final String TAG = SignalActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal);

        //create操作符
        //create();

        //just操作符
        //just();

        //from操作符
        //from();
    }

    /**
     * from操作符，可以用来操作列表或者数组数据
     */
    private void from() {
        //操作数组
        Observable.from(new Integer[]{1,2,3,4,5,6,7})
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: "+integer);
                    }
                });

        //操作列表
        List<String> items=new ArrayList<>();
        items.add("ew");
        items.add("wewe");
        items.add("re");
        items.add("etrtw");
        items.add("tyty");
        Observable.from(items)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: "+s);
                    }
                });
    }

    /**
     * just操作符，是create操作符的简写
     */
    private void just() {
        Observable.just("just操作符")
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: "+s);
                    }
                });
    }

    /**
     * create操作符
     */
    private void create() {
        Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("next操作符");
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: "+s);
            }
        });
    }
}
