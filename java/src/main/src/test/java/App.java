package com.test.coding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {

        String data = "0112322222as2n5k";

        int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<String> stringNumbers = IntStream.of(numbers).boxed().map(String::valueOf).collect(Collectors.toList());

        Map<String, Integer> matches = new HashMap<>();

        stringNumbers.forEach(i -> matches.put(i, 0));

        data.chars().forEach(item -> {
            char c = (char) item;
            if (stringNumbers.contains(String.valueOf(c))) {
                matches.merge(String.valueOf(c), 1, (a, b) -> a + b);
            }
        });

        System.out.println(matches);

    }

}

