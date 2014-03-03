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

package com.aiconoa.bpj.keywords._extendsfinal;

/**
 * Created by thomasgros on 2/23/14.
 */
public class SubClass extends SuperClass {
    public static final String A_JAVA_CONSTANT = "This is a Java constant";

    public String public2 = "SubClassPublic2";
    public String protected1 = "SubClassProtected1"; //hides
    public String private1 = "SuperClassPrivate1";

//    Can't override final methods
//    @Override
//    public void aPublicMethod() {
//        super.aPublicMethod();
//    }

    @Override
    public Integer anotherPublicMethod() {
        return new Integer(2);
    }

    public static void aStaticMethod() { //hides the SuperClass method
        System.out.println("In the SubClass");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(public1).append(System.lineSeparator());
        sb.append(public2).append(System.lineSeparator());
        sb.append(protected1).append(System.lineSeparator());
        sb.append(super.protected1).append(System.lineSeparator());
        sb.append(protected2).append(System.lineSeparator());
        sb.append(private1).append(System.lineSeparator());

        return sb.toString();
    }

}
