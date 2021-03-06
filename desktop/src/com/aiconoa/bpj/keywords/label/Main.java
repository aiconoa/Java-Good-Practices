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

package com.aiconoa.bpj.keywords.label;

import java.util.Arrays;
import java.util.List;

/**
 * Created by thomasgros on 2/21/14.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * By the way, you should be using str.contains(wordToMatch)
         */
        String str = "to be or not to be";
        String wordToMatch = "be";

        List<String> words = Arrays.asList(str.split("\\s+"));

        aLabel: {
            for (String word : words) {
                if(word.equals(wordToMatch)) {
                    break aLabel;
                }
            }
            throw new Exception("Not found :-(");
        }


        anotherLabel:
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if(j>5) {
                        continue anotherLabel;
                    }
                    System.out.println("[" + i + " : " + j + "]");
                }
            }
    }
}
