# RxJava

### 观察者模式四要素

1. Observable 被观察者

2. Observer 观察者

3. subscribe 订阅

4. 事件

![观察者模式](/img/观察者模式.png)

### 操作符

![操作符分类](/img/操作符分类.png)

1. 创建操作符

![创建操作符](/img/创建操作符.png)

##### create操作符，用来创建事件

```
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
```

##### just操作符,create操作符的简单写法

```
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
```

##### from操作符，可以用来操作数据或列表数据

```
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
```