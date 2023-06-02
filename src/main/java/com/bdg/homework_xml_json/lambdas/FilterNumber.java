package com.bdg.homework_xml_json.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNumber {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(50, 120, 80, 150, 200);

        List<Integer> filteredNumbers = filterNumbersGreaterThan100(numbers);

        System.out.println("Numbers greater than 100: " + filteredNumbers);

    }

    public static List<Integer> filterNumbersGreaterThan100(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 100)
                .collect(Collectors.toList());
    }
}
