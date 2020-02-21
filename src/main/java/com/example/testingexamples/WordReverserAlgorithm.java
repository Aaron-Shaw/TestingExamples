package com.example.testingexamples;

import java.util.List;

import static java.lang.String.*;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class WordReverserAlgorithm {

    public static String reverseEveryOtherWord(String phrase) {
        List<String> wordList = stream(phrase.trim().split(" ")).filter(x -> !x.isEmpty()).collect(toList());

        for (int i = 0; i < wordList.size(); i++) {
            if(i % 2 != 0) {
                wordList.set(i, reverse(wordList.get(i)));
            }
        }
        return join(" ", wordList);
    }

    private static String reverse(String word) {
        char[] chars = word.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
