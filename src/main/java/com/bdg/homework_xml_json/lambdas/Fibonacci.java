package com.bdg.homework_xml_json.lambdas;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {
    public static List<Long> generateFibonacci(int n) {
        return Stream.iterate(new long[] {0, 1}, t -> new long[] {t[1], t[0] + t[1]})
                .limit(n)
                .map(t -> t[0])
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // lambda exp. 4 - fibonacci
        System.out.print("Enter fibonacci number -> ");
        int n = new Scanner(System.in).nextInt();

        System.out.println(generateFibonacci(n));

    }
}
