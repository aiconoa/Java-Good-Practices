package com.aiconoa.bpj.keywords._strictfp;

/**
 * Sample taken from here http://jcs.mobile-utopia.com/jcs/510_StrictFP.java
 * Created by thomasgros on 2/23/14.
 */
public class Main {
    public static strictfp void main(String[] argv) {
        double alpha = 8e+307;
        System.out.println(mulNotStrict(alpha));
        System.out.println(mulStrictFP(alpha));
        System.out.println(2 * alpha);
    }

    static double mulNotStrict(double a) {
        return a * 4 * 0.5;
    }
    static strictfp double mulStrictFP(double a) {
        return a * 4 * 0.5;
    }
}
