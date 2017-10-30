package com.lytech.xvjialing.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class ErrorHandlingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_handling);

        //onErrorReturn操作符
        onErrorReturn();

        //onErrorResumeNext
        onErrorResumeNext();

        //onExceptionResumeNext
        onExceptionResumeNext();

        //retry
        retry();

        //retryWhen
        retryWhen();
    }

    private void retryWhen() {
//        Observable.create((Subscriber<? super String> s) -> {
//            System.out.println("subscribing");
//            s.onError(new RuntimeException("always fails"));
//        }).retryWhen(attempts -> {
//            return attempts.zipWith(Observable.range(1, 3), (n, i) -> i).flatMap(i -> {
//                System.out.println("delay retry by " + i + " second(s)");
//                return Observable.timer(i, TimeUnit.SECONDS);
//            });
//        }).toBlocking().forEach(System.out::println);
    }

    private void retry() {

    }

    private void onExceptionResumeNext() {

    }

    private void onErrorResumeNext() {

    }

    /**
     * onErrorReturn操作符
     *
     */
    private void onErrorReturn() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {

            }
        })
        .onErrorReturn(new Func1<Throwable, Integer>() {
            @Override
            public Integer call(Throwable throwable) {
                return null;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {

            }
        });
    }
}
