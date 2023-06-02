package com.bdg.homework_xml_json.lambdas;

import java.util.Arrays;
import java.util.List;

public class AverageStringLength {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("apple", "orange", "ant", "banana", "avocado");

        double averageLength = findAverageLength(strings);

        System.out.println("Average length of strings starting with 'a': " + averageLength);

    }
    public static double findAverageLength(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("a"))
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
    }
}
