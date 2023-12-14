package com.example.springthreads;

import reactor.core.publisher.Mono;

public class ReactiveStream {

    public static void main(String[] args) {
        int number = 15;

        Mono<Integer> result = processNumber(number);
        result.subscribe(System.out::println);
    }

    public static Mono<Integer> processNumber(int number) {
        return toMono(number)
                .map(ReactiveStream::squareNumber)
                .map(ReactiveStream::calculateSumOfDigits);

    }

    public static int squareNumber(int number) {
        return number * number;
    }

    public static int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static <T> Mono<T> toMono(T value) {
        return Mono.justOrEmpty(value);
    }
}
