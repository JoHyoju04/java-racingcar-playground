import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public int calculate(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        String[] splitResult = split(text);
        return sum(splitResult);
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(Pattern.quote(customDelimiter));
        }
        return text.split(DEFAULT_DELIMITERS);
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(this::toPositiveNumber)
                .sum();
    }

    private int toPositiveNumber(String number) {
        try {
            int value = Integer.parseInt(number);
            if (value < 0) {
                throw new RuntimeException("음수는 허용되지 않습니다: " + number);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다: " + number, e);
        }
    }
}
