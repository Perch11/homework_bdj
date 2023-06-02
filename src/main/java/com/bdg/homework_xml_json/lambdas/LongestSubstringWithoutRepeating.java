package com.bdg.homework_xml_json.lambdas;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String input = "abcabcbb";

        String longestSubstring = findLongestSubstring(input);

        System.out.println("Longest substring without repeating characters: " + longestSubstring);
    }

    public static String findLongestSubstring(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        Map<Character, Integer> charMap = new HashMap<>();
        int[] longest = {0};
        int[] start = {0};

        input.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> {
                    int index = charMap.getOrDefault(c, -1);
                    if (index >= start[0]) {
                        longest[0] = Math.max(longest[0], index - start[0]);
                        start[0] = index + 1;
                    }
                    charMap.put(c, start[0]);
                });

        longest[0] = Math.max(longest[0], input.length() - start[0]);

        return input.substring(start[0], start[0] + longest[0]);
    }
}
