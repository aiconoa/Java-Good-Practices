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

package com.aiconoa.bpj.collections.nonconcurrent;

import com.aiconoa.bpj.model.Person;

import java.util.*;

/**
 * Created by thomasgros on 2/25/14.
 */
public class MainQueue {
    public static void main(String[] args) {
        Queue<Person> waitingLine = new ArrayDeque<>();
        Queue<Person> youngestFirstLine = new PriorityQueue<>();

        for(Person p: Person.personsFakeList()) {
            waitingLine.add(p);
            youngestFirstLine.add(p);
        }

        Person p = null;

        System.out.println("###### QUEUE / FIFO");
        while((p = waitingLine.poll()) != null) {
            System.out.println(p);
        }

        System.out.println("###### QUEUE / PRIORITY");
        while((p = youngestFirstLine.poll()) != null) {
            System.out.println(p);
        }



    }
}
