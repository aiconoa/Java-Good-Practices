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

package com.aiconoa.bpj.classloader;

/**
 * Created by thomasgros on 2/23/14.
 */
public class Main {
    public static void main(String[] args) {

        try {
            // Dynamic class loading
            ClassLoader classLoader = Main.class.getClassLoader(); // here we choose our class loader
            //  // class is not initialized.
            // see http://docs.oracle.com/javase/specs/jls/se7/html/jls-12.html#jls-12.4
            Class clazz1 = classLoader.loadClass("com.aiconoa.bpj.classloader.SomeClass");
            System.out.println("clazz1.getCanonicalName()" + clazz1.getCanonicalName());
            System.out.println(clazz1.getClassLoader());
            //clazz1.newInstance();

            // uses the current class loader + class is initialized + associates this class with the used classloader (ClassLoader.findLoadedClass will succeed next time)
            Class clazz2 = Class.forName("com.aiconoa.bpj.classloader.SomeOtherClass");
            System.out.println("clazz1.getCanonicalName()" + clazz1.getCanonicalName());
            //clazz2.newInstance();

            CustomClassLoader ccl = new CustomClassLoader(Main.class.getClassLoader());
            Class clazz3 = ccl.loadClass("com.aiconoa.bpj.classloader.SomeClass"); // yes, we can load two classes with the same name but with different classloaders
            System.out.println("clazz3.getCanonicalName()" + clazz3.getCanonicalName());
            System.out.println(clazz3.getClassLoader());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
