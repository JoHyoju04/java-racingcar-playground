import java.util.Arrays;

public class StringCalculator {
    public StringCalculator(){

    }

    public int calculate(String str){
        int sum = 0;
        StringBuilder currentNumber = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Integer.parseInt(String.valueOf(c));
            } else if (c != ',' && c != ':') {
                throw new RuntimeException("문자가 들어왔습니다.");
            }
        }

        return sum;
    }
}
