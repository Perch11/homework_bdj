package com.bdg.homework_xml_json.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringAscendingLength {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("Bananaaa", "Banannnnnnnananan", "Helicopter", "Radiator"));
        strings.sort(Comparator.comparingInt(String::length));
        System.out.println("Sorted strings: " + strings);

    }
}
