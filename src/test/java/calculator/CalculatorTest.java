package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void shouldreturnDoubleValue(){
        assertEquals(Calculator.evaluateText("123"), -1);
    }

}