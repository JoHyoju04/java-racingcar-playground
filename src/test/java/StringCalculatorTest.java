import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void 쉼표_구분자를_기준으로_분리해서_더한다(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("1,4");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 콜론_구분자를_기준으로_분리해서_더한다(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("1:4");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 쉼표와_콜론_구분자를_기준으로_분리해서_더한다(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("1:4,2:4");
        assertThat(result).isEqualTo(11);
    }

    @Test
    void 문자가_들어오면_예외(){
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> calculator.calculate("ab:,")).isInstanceOf(RuntimeException.class);
    }

}