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

package com.aiconoa.bpj.keywords._instanceof;

import com.aiconoa.bpj.keywords._class.MyInterface;
import com.aiconoa.bpj.keywords._implements.MyInterface3;
import com.aiconoa.bpj.keywords._implements.MyInterface4;

/**
 * Created by thomasgros on 2/23/14.
 */
public class Main {
    public static void main(String[] args) {
        MyInterface3 someObject = new MyInterface3() {
            @Override
            public void method3() {
                System.out.println("method3");
            }

            @Override
            public void method4() {
                System.out.println("method4");
            }
        };

        System.out.println(someObject instanceof MyInterface3);
        System.out.println(someObject instanceof MyInterface4);

        MyInterface someOtherObject = null;

        if(someOtherObject instanceof MyInterface ) {
            // no need for null testing, ie (someOtherObject != null  && someOtherObject instanceof MyInterface)
            System.out.println("someOtherObject is an instance of " + MyInterface.class);
        } else {
            System.out.println("someOtherObject is NOT an instance of " + MyInterface.class);
        }
    }
}
