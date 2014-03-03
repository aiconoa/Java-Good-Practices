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

package com.aiconoa.bpj.interfaces.comparable;

import com.aiconoa.bpj.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thomasgros on 2/25/14.
 */
public class MainComparable {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Iris", "Ramirez", 24));
        persons.add(new Person("Nichole", "Ortega", 15));
        persons.add(new Person("Emma", "Jones", 36));
        persons.add(new Person("Greg", "Stevens", 65));
        persons.add(new Person("Esther", "Haynes", 42));
        persons.add(new Person("Marguerite", "Russell", 21));
        persons.add(new Person("Geraldine", "Ballard", 38));

        System.out.println("##### SORTING / NATURAL ORDER");
        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println(person.toString());
        }

        System.out.println("##### SORTING / SHUFFLE");
        Collections.shuffle(persons);
        for (Person person : persons) {
            System.out.println(person.toString());
        }

        System.out.println("##### SORTING / COMPARATOR / REVERSE ORDER");
        Collections.reverseOrder(new PersonComparator());
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
