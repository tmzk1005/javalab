package zk.javalab.resilience4j.circuitbreaker;

import java.time.Duration;
import java.util.function.Supplier;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;

public class CircuitBreakerDemo {

    public static void main(String[] args) {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(2)
            .waitDurationInOpenState(Duration.ofMillis(2000))
            .permittedNumberOfCallsInHalfOpenState(2)
            .slidingWindowSize(4)
            .recordExceptions(IllegalStateException.class)
            .build();
        CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);

        final CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("demo");
        final Supplier<String> stringSupplier = CircuitBreaker.decorateSupplier(circuitBreaker, CircuitBreakerDemo::getName);
        for (int i = 0; i < 100; ++i) {
            System.out.println(Try.ofSupplier(stringSupplier).recover(throwable -> {
                System.out.println("recover from " + throwable.getClass().getName());
                return "bob";
            }).get());
        }
    }

    public static String getName() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis % 2 == 0) {
            System.out.println("return alice");
            return "alice";
        }
        System.out.println("exception");
        throw new IllegalStateException("exception");
    }

}
