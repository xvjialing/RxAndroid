package com.lytech.xvjialing.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

public class SignalActivity extends AppCompatActivity {

    private static final String TAG = SignalActivity.class.getSimpleName();

    private String deferStr;

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

        //defer操作符
        //defer();

        //empty操作符
        //empty();

        //never操作符
        //never();

        //interval操作符
        //interval();

        //range操作符
        //range();

        //repeat操作符
        //repeat();

        //timer操作符
        //timer();
    }

    /**
     * timer操作符
     * create an Observable that emits a single item after a given delay
     * 创建一个Observable，在给定的延迟后发出单个项目
     */
    private void timer() {
        Observable
            .timer(5,TimeUnit.SECONDS)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "onNext: "+aLong);
                    }
                });
    }


    /**
     * repeat操作符
     * create an Observable that emits a particular item or sequence of items repeatedly
     * 创建一个可以重复发出特定项目或序列的Observable
     */
    private void repeat() {
        Observable.just(1,2)
                .repeat(2)
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
    }

    /**
     * range操作符
     *  create an Observable that emits a range of sequential integers
     *  创建一个可发出一系列顺序整数的Observable
     */
    private void range() {
        Observable.range(1,100)
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
    }

    /**
     * interval操作符
     *  create an Observable that emits a sequence of integers spaced by a particular time interval
     *  创建一个Observable，发出一个以特定时间间隔间隔的整数序列
     */
    private void interval() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "onNext: "+aLong);
                    }
                });
    }


    /**
     * never操作符
     *create an Observable that emits no items and does not terminate
     *创建一个Observable，它不会发出任何项目，也不会终止
     */
    private void never() {
        Observable.never()
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.d(TAG, "onNext: ");
                    }
                });
    }

    /**
     * empty操作符
     *create an Observable that emits no items but terminates normally
     * 创建一个Observable，它不会发送任何东西但是正常终止
     */
    private void empty() {
        Observable.empty()
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.d(TAG, "onNext: ");
                    }
                });
    }

    /**
     * defer操作符
     *do not create the Observable until the observer subscribes, and create a fresh Observable for each observer
     * 直到观察者者（observer）订阅后后才会创建被观察者（observable）
     */
    private void defer() {
        Observable observable=Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(deferStr);
            }
        });

        Observable observable1=Observable.just(deferStr);

        deferStr="deferstr";

        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "observable"+"onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "observable"+"onError: ");
            }

            @Override
            public void onNext(String str) {
                Log.d(TAG, "observable"+"onNext: "+str);
            }
        });

        observable1.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "observable1"+"onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "observable1"+"onError: ");
            }

            @Override
            public void onNext(String str) {
                Log.d(TAG, "observable1"+"onNext: "+str);
            }
        });
    }

    /**
     * from操作符，
     *convert some other object or data structure into an Observable
     * 可以用来操作列表或者数组数据
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
     * just操作符
     * convert an object or a set of objects into an Observable that emits that or those objects
     * 将对象或一组对象转换为发出该对象或那些对象的Observable
     * 是create操作符的简写
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
     *  create an Observable from scratch by calling observer methods programmatically
     *  通过编程方式调用观察器方法从头创建一个Observable
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
