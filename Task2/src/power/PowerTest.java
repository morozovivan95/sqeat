package power;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerTest {

    private Power testee = new Power();

    @Test
    public void shouldBeAbleToPow() throws Exception {
        assertEquals(1024, testee.pow(2, 10));
    }

    @Test
    public void shouldBeOneIfPowerIsZero() {
        assertEquals(1, testee.pow(2, 0));
    }

    @Test
    public void shouldBeOneIfPowerIsNegative() {
        assertEquals(1, testee.pow(2, -1));
    }

    @Test
    public void shouldBeINT_MAXIfResultIsGreaterThanINT_MAX() {
        assertEquals(Integer.MAX_VALUE, testee.pow(Integer.MAX_VALUE, 2));
    }
}