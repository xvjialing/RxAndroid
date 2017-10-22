package com.lytech.xvjialing.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;

public class TransformingActivity extends AppCompatActivity {

    private static final String TAG = TransformingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transforming);

        //map操作符
        //map();

        //flatMap操作符
        //flatMap();

        //groupBy操作符
        //groupBy();

        //buffer操作符
        //buffer();

        //scan操作符
        //scan();

        //window操作符
        window();
    }

    /**
     * window操作符
     * periodically subdivide items from an Observable into Observable windows and emit these windows rather than emitting the items one at a time
     * 将Observable中的项目定期细分为Observable，并发出Observable，而不是一次发送一个项目
     */
    private void window() {
        Observable.range(1,5)
                .window(3)
                .subscribe(new Observer<Observable<Integer>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Observable<Integer> integerObservable) {
                        integerObservable.subscribe(new Subscriber<Integer>() {
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
                });
    }

    /**
     * scan操作符
     * apply a function to each item emitted by an Observable, sequentially, and emit each successive value
     * 对Observable发出的每个项目顺序应用一个函数，并发出每个连续的值
     */
    private void scan() {
        Observable.range(1,5)
                .scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer sum, Integer integer2) {
                        return sum+integer2;
                    }
                })
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
     * buffer操作符
     * periodically gather items from an Observable into bundles and emit these bundles rather than emitting the items one at a time
     * 定期将可观察的项目收集到捆绑包中，并发布这些捆绑包，而不是一次发送一个项目
     * 可以将数据中的多个一次性发给观察者
     */
    private void buffer() {
        Observable.range(1,9)
                .buffer(3)
                .subscribe(new Subscriber<List<Integer>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        Log.d(TAG, "onNext: "+integers);
                    }
                });
    }

    /**
     * groupBy操作符
     * divide an Observable into a set of Observables that each emit a different group of items from the original Observable, organized by key
     * 将一个Observable分成一组可观察值，每个Observable可以从原始的Observable发出一组不同的项目，按键组织
     */
    private void groupBy() {
        Observable.just(1,2,3,4,5,6,7)
                .groupBy(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer % 2;
                    }
                })
                .subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                        integerIntegerGroupedObservable.subscribe(new Subscriber<Integer>() {
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
                                Log.d(TAG, "onNext: "+"group"+integerIntegerGroupedObservable.getKey()+":"+integer);
                            }
                        });
                    }
                });
    }

    /**
     * flatMap操作符
     * transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
     * 将Observable发射的项目转换为Observables，然后将其中的排放物平坦化为单个Observable
     */
    private void flatMap() {
        Observable.just(1,3,5,7,9)
                .flatMap(new Func1<Integer, Observable<String>>() {
                    @Override
                    public Observable<String> call(Integer integer) {
                        return Observable.just((integer+1)+"");
                    }
                })
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
     * map操作符
     * transform the items emitted by an Observable by applying a function to each item
     * 通过对每个项目应用函数来转换Observable发出的项目
     * 可以用来做类型转换
     */
    private void map() {
        Observable.just(123)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer+"";
                    }
                })
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
}
