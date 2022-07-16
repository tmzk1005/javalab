package zk.javalab.jdk17.reactive;

import java.util.concurrent.Flow;

public class MyProcessor implements Flow.Processor<String, String> {

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(String item) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {
    }

}
