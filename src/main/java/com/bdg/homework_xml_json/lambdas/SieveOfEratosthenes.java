package com.bdg.homework_xml_json.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SieveOfEratosthenes {
    public static void main(String[] args) {

        int limit = 30;
        List<Integer> primes = findPrimes(limit);
        System.out.println("Prime numbers up to " + limit + ": " + primes);

    }

    public static List<Integer> findPrimes(int limit) {
        if (limit < 2) {
            return new ArrayList<>();
        }

        boolean[] isComposite = new boolean[limit + 1];
        isComposite[0] = true;
        isComposite[1] = true;

        IntPredicate isNotComposite = index -> !isComposite[index];

        IntStream.rangeClosed(2, (int) Math.sqrt(limit))
                .filter(isNotComposite)
                .forEach(prime -> markMultiplesAsComposite(isComposite, prime));

        return IntStream.rangeClosed(2, limit)
                .filter(isNotComposite)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void markMultiplesAsComposite(boolean[] isComposite, int prime) {
        for (int i = prime * prime; i < isComposite.length; i += prime) {
            isComposite[i] = true;
        }
    }
}
