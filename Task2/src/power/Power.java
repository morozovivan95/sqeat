package power;

public class Power {
    /**
     * Binary power function, complexity is O(log(exponent))
     *
     * @param base     - the base to power
     * @param exponent - the exponent to power in
     * @return - result of base ^ exponent
     */
    public int pow(int base, int exponent) {
        Long result = 1L;

        while (exponent > 0) {
            if (checkOwerflowing(base, result)) return Integer.MAX_VALUE;

            if (isOdd(exponent)) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }

        return result.intValue();
    }

    private boolean isOdd(int exponent) {
        return (exponent & 1) != 0;
    }

    private boolean checkOwerflowing(int base, Long result) {
        return result >= Integer.MAX_VALUE / base || base >= Integer.MAX_VALUE / base;
    }
}