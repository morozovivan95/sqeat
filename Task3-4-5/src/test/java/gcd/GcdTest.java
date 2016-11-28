package gcd;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GcdTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {20, 10, 10},
            {-24, -18, 6},
            {0, 500, 500},
            {0, -49, 0},
            {100, -50, 50},
            {Integer.MAX_VALUE, 40, 1},
            {Integer.MAX_VALUE, -100, 1},
            {Integer.MIN_VALUE, 2, 2},
            {Integer.MIN_VALUE, -2, 2},
            {Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
            {Integer.MIN_VALUE, 0, Integer.MIN_VALUE},
            {Integer.MAX_VALUE, Integer.MIN_VALUE, 1},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}
        });
    }

    int firstArg;
    int secondArg;
    int expectedResult;

    public GcdTest(int firstArg, int secondArg, int expectedResult) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.expectedResult = expectedResult;
    }

    @org.junit.Test
    public void gcd() throws Exception {
        final Gcd gcd = new Gcd();
        assertEquals(expectedResult, gcd.gcd(firstArg, secondArg));
    }
}