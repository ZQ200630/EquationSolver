package com.zq.util;

import com.zq.entity.Fraction;

public class FloatDispose {
    public static Fraction doubleToFrac(int i, int s) {
        String str = i + String.valueOf(s);
        int a = Integer.valueOf(str);
        int b = (int) Math.pow(10, digit(s));
        int gcd = gcd(a, b);
        return new Fraction(a/gcd, b/gcd);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    private static int digit(int x) {
        int number=0; //计数
        while(x>=1) {
            x/=10;
            number++;
        }
        return number;
    }
}
