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

package com.aiconoa.bpj.keywords.trycatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/**
 * Created by thomasgros on 2/21/14.
 */
public class Main {
    public static void main(String[] args) {
        try {
            throwsException1();
            throwsException2();
        } catch (MyException1 | MyException2 ex) { // FROM Java 7 you can catch more than one exception
            ex.printStackTrace();
        }

        try {
            URL url = new URL("http://www.example.com");
            // Using a decoder is a good way to react to encoding problems
            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder(); // supported encodings http://docs.oracle.com/javase/7/docs/technotes/guides/intl/overview.html
            decoder.onMalformedInput(CodingErrorAction.IGNORE);
            // Try with resource => will close the closeable
            // Readers read char streams
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), decoder))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch(MalformedURLException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Ok, we're done");
        }

        bewareIWontThrowTheException();

        throw null; // you can throw null :-)

    }

    public static void throwsException1() throws MyException1 {
        throw new MyException1();
    }

    public static void throwsException2() throws MyException2 {
        throw new MyException2();
    }

    public static void bewareIWontThrowTheException() {
        try {
            throw new RuntimeException();
        } finally {
            //don 't return in finally clause
            return; // will make the exception disappear... tadaaa !
        }
    }
}
