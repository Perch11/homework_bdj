package com.bdg.homework_xml_json.lambdas;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        String input = "hello world";

        Character firstNonRepeating = findFirstNonRepeating(input);

        System.out.println("First non-repeating character: " + firstNonRepeating);

    }

    public static Character findFirstNonRepeating(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        input.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1));

        return charCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
