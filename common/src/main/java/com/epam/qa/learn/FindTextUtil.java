package com.epam.qa.learn;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FindTextUtil {

    private FindTextUtil() {

    }

    public static Optional<String> find(String sourceText, String searchRegx) {
        Pattern pattern = Pattern.compile(searchRegx);
        Matcher matcher = pattern.matcher(sourceText);
        Optional<String> result = Optional.empty();
        while (matcher.find()) {
            result = Optional.of(sourceText.substring(matcher.start(), matcher.end()));
        }
        return result;
    }

    public static String findAndReplace(String sourceText, String searchRegx, String replaceRegx) {
        Optional<String> result = find(sourceText, searchRegx);
        return result.map(s -> sourceText.replaceAll(s, replaceRegx)).orElse(sourceText);
    }
}
