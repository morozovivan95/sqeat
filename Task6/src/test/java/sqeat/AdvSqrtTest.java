package sqeat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AdvSqrtTest {

    AdvSqrt testee = new AdvSqrt();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {16, 4},
            {Double.NaN, Double.NaN},
            {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
            {Double.longBitsToDouble(0x0001000000000000L), 3.7291703656001034E-155},
            {2.2250738585072014E-308, 1.4916681462400413E-154},
            {-0, -0},
            {8, Math.sqrt(8)}
        });
    }

    double sqrValue;
    double result;

    public AdvSqrtTest(double sqrValue, double result) {
        this.sqrValue = sqrValue;
        this.result = result;
    }

    @Test
    public void sqrt() throws Exception {
        assertEquals(testee.sqrt(sqrValue), result, 0.0001);
    }
}