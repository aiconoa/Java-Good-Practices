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

package com.aiconoa.bpj.keywords.loops;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by thomasgros on 2/23/14.
 */
public class Main {
    private static Random random = new Random();

    public static boolean someCondition() {
        return random.nextBoolean();
    }

    public static void main(String[] args) {
        int i = 0;
        System.out.println("Do loop");
        do {
            System.out.println(i);
            i++;
        } while(someCondition());

        System.out.println("While loop");
        while(someCondition()) {
            System.out.println(i);
            i++;
        }

        System.out.println("for loop");
        for (int j = 0; j < 0; j++) {
            System.out.println(j);
        }

        System.out.println("foreach loop");
        List<String> l = Arrays.asList("to", "be", "or", "not", "to", "be");
        for (String s : l) {
            System.out.print(s);
        }

    }
}
