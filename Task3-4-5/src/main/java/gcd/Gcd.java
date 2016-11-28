package gcd;

public class Gcd {
    public int gcd(int x, int y) {
        int t;

        if (x < 0) x = -x;
        if (y < 0) y = -y;

        while (y != 0) {
            if (y > x) {
                x = y - x;
                y = y - x;
                x = x + y;
            }

            if (y == 0) return x;

            t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
}