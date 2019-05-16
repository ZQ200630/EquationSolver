package com.zq.util;

import com.zq.entity.Fraction;

public class Operation {
    public static Fraction add(Fraction a, Fraction b) {
        int top = a.getTop() * b.getBottom() + a.getBottom() * b.getTop();
        int bottom = a.getBottom() * b.getBottom();
        return new Fraction(top, bottom);
    }


    public static Fraction minus(Fraction a, Fraction b) {
        int top = a.getTop() * b.getBottom() - a.getBottom() * b.getTop();
        int bottom = a.getBottom() * b.getBottom();
        return new Fraction(top, bottom);
    }


    public static Fraction product(Fraction a, Fraction b) {
        int top = a.getTop() * b.getTop();
        int bottom = a.getBottom() * b.getBottom();
        return new Fraction(top, bottom);
    }


    public static Fraction divide(Fraction a, Fraction b) {
        int top = a.getTop() * b.getBottom();
        int bottom = a.getBottom() * b.getTop();
        return new Fraction(top, bottom);
    }

    public static boolean equals(Fraction a, Fraction b) {
        if(a.getTop() == 0) {
            if (b.getTop() == 0) {
                return true;
            }else{
                return false;
            }
        } else {
            Fraction ca  = new Fraction(a.getTop()/gcd(a.getTop(),a.getBottom()), a.getBottom() / gcd(a.getTop(),a.getBottom()));
            Fraction cb  = new Fraction(b.getTop()/gcd(b.getTop(),b.getBottom()), b.getBottom() / gcd(b.getTop(),b.getBottom()));
            if(ca.getTop() == cb.getTop() && ca.getBottom() == cb.getBottom()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
