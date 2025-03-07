package com.intern.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Capitalization {

    private static String capitalize(String input) {
        String[] words = input.toLowerCase(Locale.ROOT).split("\\s");
        StringBuilder output = new StringBuilder();
        for (String word : words) {
            output.append(StringUtils.capitalize(word)).append(" ");
        }
        return output.toString().trim();
    }

    public static Map<String, List<String>> convertToMap(List<Book> inputs) {
        for(Book input : inputs) {
            input.setAuthor(capitalize(input.getAuthor()));
            input.setTitle(capitalize(input.getTitle()));
        }
        return inputs.stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors.mapping(Book::getTitle, Collectors.toList())));
    }
}
