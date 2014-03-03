/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 AICONOA
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.aiconoa.bpj.keywords._return;

import java.util.Random;

/**
 * Created by thomasgros on 2/23/14.
 */
public class Main {
    public static void main(String[] args) {
        return1();
        System.out.println(return2());
        return3();
        return4();
    }

    // a method will return if the last statement is reached
    public static void return1() {

    }

    // a method will return explicitely if the return keyword is used
    public static String return2() {
        return "Hello";
    }

    // a method will return explicitely if the return keyword is used
    public static void return3() {
        if((new Random()).nextBoolean()) {
            System.out.println("True");
            return;
        }

        System.out.println("False");
    }

    // a method will return in case of an exception
    public static void return4() {
        if((new Random()).nextBoolean()) {
            throw new RuntimeException("This is an exception");
        }
        System.out.println("Hello !");
    }

    public static String return5() {
        while(true){
            //no need for return, the compiler knows about reachability of the rest of the code. Normal termination is not possible here.

// JLS http://docs.oracle.com/javase/specs/jls/se7/html/jls-8.html#jls-8.4.7
// If a method is declared to have a return type, then a compile-time error occurs if the body of the method can complete normally.
// In other words, a method with a return type must return only by using a return statement that provides a value return;
// it is not allowed to "drop off the end of its body".
        }
    }
}
