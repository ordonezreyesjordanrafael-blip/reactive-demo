package com.example.reactive;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class ReactiveDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 10)                                   // Publisher: emits 1..10
            .filter(n -> n % 2 == 0)                        // keeps even numbers
            .map(n -> n * n)                                // squares each one
            .delayElements(Duration.ofMillis(200))          // async, non-blocking delay
            .subscribe(
                v -> System.out.println("Received: " + v),  // onNext
                e -> System.err.println("Error: " + e),     // onError
                () -> System.out.println("Completed")       // onComplete
            );

        Thread.sleep(1500); // keep the JVM alive: emission runs on another thread
    }
}
