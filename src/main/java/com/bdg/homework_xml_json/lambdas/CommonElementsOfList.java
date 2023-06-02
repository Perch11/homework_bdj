package com.bdg.homework_xml_json.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonElementsOfList {

    @SafeVarargs
    public static List<Integer> findCommonElements(List<Integer>... lists) {
        // Convert the array of lists into a stream
        List<List<Integer>> listOfLists = Arrays.asList(lists);

        List<Integer> commonElements;
        // Find the common elements using a lambda expression

        commonElements = listOfLists.stream()
                .flatMap(List::stream)
                .distinct()
                .filter(element -> listOfLists.stream().allMatch(list -> list.contains(element)))
                .collect(Collectors.toList());
        return commonElements;
    }

    public static void main(String[] args) {

        // lambda exe. 5
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> list3 = Arrays.asList(3, 4, 5, 9, 10);
        // Find the common elements in the lists
        List<Integer> commonElements = findCommonElements(list1, list2, list3);
        // Print the common elements
        System.out.println(commonElements);

    }
}
