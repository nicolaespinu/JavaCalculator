package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @Test
    public void shouldVerifyForEmptyString() {
        assertEquals(0, Calculator.evaluateText(""));
    }

    @Test
    public void shouldReturnDoubleValueIfNotHaveOperators() {
        assertEquals(123.0, Calculator.evaluateText("123"));
        assertEquals(77, Calculator.evaluateText("77"));
        assertEquals(1, Calculator.evaluateText("1"));
    }

    @Test
    public void shouldVerifyAddOperator() {
        assertEquals(5.0, Calculator.evaluateText("2 + 3"));
        assertEquals(105.0, Calculator.evaluateText("2 + 3 + 100"));
        assertEquals(3.0, Calculator.evaluateText("-2 + 2 + 3"));
    }

    @Test
    public void shouldVerifyMinusOperator() {
        assertEquals(-1.0, Calculator.evaluateText("2 - 3"));
        assertEquals(-5.0, Calculator.evaluateText("-2 - 3"));
        assertEquals(-5.0, Calculator.evaluateText("-2 + -3"));
    }

    @Test
    public void shouldVerifyMultiplyOperator() {
        assertEquals(59.0, Calculator.evaluateText("2 + 3 + 6 * 9"));
        assertEquals(324.0, Calculator.evaluateText("2 * 3 * 6 * 9"));
        assertEquals(-48.0, Calculator.evaluateText("2 * 3 - 6 * 9"));
    }

    @Test
    public void shouldVerifyDivideOperator() {
        assertEquals(5.0, Calculator.evaluateText("5 / 5 + 4 "));
        assertEquals(4.0, Calculator.evaluateText("3 + 5 / 5"));
        assertEquals(-3.0, Calculator.evaluateText("1 - 4 * 5 / 5"));
    }

    @Test
    public void shouldVerifyExpressionWithBrackets() {
        assertEquals(11.0, Calculator.evaluateText("( 5 + 6 )"));
        assertEquals(-74.0, Calculator.evaluateText("2 + 3 / 3 - 7 * ( 5 + 6 )"));
        assertEquals(-114.0, Calculator.evaluateText("52 - ( 3 + 32 ) + ( -19 - 8 ) * 5 + 4 "));
        assertEquals(1116, Calculator.evaluateText("( 34 + 24 * 52 - ( 3 + 32 ) ) + ( -19 - 8 ) * 5 + 4 "));
    }
}