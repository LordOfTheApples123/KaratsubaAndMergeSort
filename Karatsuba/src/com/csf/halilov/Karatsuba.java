package com.csf.halilov;

import java.math.BigInteger;
import java.util.Random;

public class Karatsuba {
    private final static BigInteger ZERO = new BigInteger("0");

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {


        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);

        N = (N / 2) + (N % 2);

        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        BigInteger ac    = karatsuba(a, c);
        BigInteger bd    = karatsuba(b, d);
        BigInteger abcd  = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }





    public static void karatsubaTest() {
        long start, stop, time;
        Random random = new Random();
        BigInteger a = new BigInteger(64, random);
        BigInteger b = new BigInteger(64, random);

        System.out.println("Значения умножаемых элементов: " + a + "; " + b);
        BigInteger c = karatsuba(a, b);
        BigInteger d = a.multiply(b);
        System.out.println(("Правильность результата алгоритма Карацубы: " + c.equals(d)));
    }
}
