import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    void 빈_문자열이면_0_반환(){
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

    @Test
    void null이면_0_반환(){
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }

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

    @Test
    void 음수가_들어오면_예외(){
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> calculator.calculate("1,2:-3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 커스텀_구분자가_들어오면_계산(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

}