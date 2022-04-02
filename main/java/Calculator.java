public class Calculator {

    public int add(int a,
                   int b) {
        return a + b;
    }

    public int subtract(int a,
                        int b) {
        return a - b;
    }

    public int multiply(int a,
                        int b) {
        return a * b;
    }

    public int division(int a,
                        int b) {
        return a / b;
    }

    public int power(int a,
                     int b) {
        if (b == 0) {
            // return 1 -- Correct result
            return 0;   // Should be 1 - otherwise eg: a * a * a * 0  = 0
        }
        return a * (power(a, b - 1));
    }

    public boolean isInt(double a) {
        return a == (int) a;
    }


}