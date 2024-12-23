package com.demat.starter;

/**
 * @author TNAJI Khalid
 */
public class Chap14mathApi {
    public static void main(String[] args) {
        long a = 5;
        int b = 3;
        long c = Math.max(a, b); // int, long => long (autocasting)

        // round() -> takes decimal number and returns integral number
        // if parameter is float, return type will be int
        // if parameter is double, return type will be long
        double d = 2.56;
        long a1 = Math.round(d);
        //=> 3
        //
        double d2 = 2.4;
        long a2 = Math.round(d);
        //=> 3

        // ceil() and floor()
        // take any number and always returns double

        double r = Math.ceil(2.45);
        //=> 3.0
        double p = Math.floor(2.45);
        //=> 2.0
        double q = Math.floor(2.99);
        //=> 2.0

        // exponents: pow()
        // takes any number, returns double

        double ran = Math.random();
        //random number between 0 and 1.0 (not included)
    }
}
