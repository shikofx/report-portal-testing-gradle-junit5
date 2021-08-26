import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FindTextUtil {

    private FindTextUtil() {

    }

    public Optional<String> find(String sourceText, String searchRegx) {
        Pattern pattern = Pattern.compile(searchRegx);
        Matcher matcher = pattern.matcher(sourceText);
        Optional<String> result = Optional.empty();
        while (matcher.find()) {
            result = Optional.of(sourceText.substring(matcher.start(), matcher.end()));
        }
        return result;
    }

    public String findAndReplace(String sourceText, String searchRegx, String replaceRegx) {
        Optional<String> result = find(sourceText, searchRegx);
        if (result.isPresent()) {
            return result.get().replaceAll(replaceRegx, "");
        } else {
            return sourceText;
        }
    }
}
