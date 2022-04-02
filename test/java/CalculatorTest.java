import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Nested
    class TypeChecks {

        @ParameterizedTest  // Loops through all elements in the @ValueSource
        @ValueSource(doubles = {5.0, 4.0, 13.0, 4.5})
        void isInt(double i) {
            assertTrue(calculator.isInt(i)); // A bug on purpose in 4.5
        }

        @ParameterizedTest
        @CsvSource(value = {"4.0, true", "5.0, true", "4.8, false"})
        void isInt2(double j,
                    boolean k) {
            assertEquals(k, calculator.isInt(j));
        }


        @Test
        void isNull() {
            Integer i = null;

            assertThrows(NullPointerException.class,

                    () -> {
                        i.intValue();
                    }

            );
        }

    }


    @Nested
    class Calculations {

        @Test
        @DisplayName("2 + 1 = 3")
        void addsTwoNumbers() {
            assertEquals(3, calculator.add(2, 1), "2+1 should equal 3");
        }

        @Test
        @DisplayName("2 - 1 = 1")
        void subtractsTwoNumbers() {
            assertEquals(1, calculator.subtract(2, 1), "2-1 should equal 1");
        }

        @Test
        @DisplayName("3 * 2 = 6")
        void multiplyTwoNumbers() {
            assertEquals(6, calculator.multiply(3, 2), "2*1 should equal 1");
        }

        @Test
        @DisplayName("4 / 2 = 2")
        void divideTwoNumbers() {
            assertEquals(2, calculator.divide(4, 2));
        }

        @Test
        @DisplayName("2 ^ 3 = 8")
        void power() {
            assertEquals(8, calculator.power(2, 3));
        }

    }
}