package org.neetcode.math.geometry;

public class Power {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        } if(x == 1) {
            return 1;
        }
        if (n == Integer.MIN_VALUE)
        {
            x = x * x;
            n = n / 2;
        }
        if(n < 0) {
            x = 1/x;
            n = n * (-1);
        }
        double res = 1;
        while (n > 0) {
            if (n % 2 == 1)
                res *= x;

            x *= x;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.myPow(2.00000, -2147483648));
    }
}
