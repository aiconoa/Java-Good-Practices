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

package com.aiconoa.bpj.keywords.primitivetypes;

import java.io.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;

/**
 * Created by thomasgros on 2/21/14.
 * @link <a href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.2">JLS Primitive types and values</a>
 * @link <a href="http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">Datatypes, Java Tutorial</a>
 */
public class Main {

    public static void main(String[] args) {
//        booleanStuff();
//        byteStuff();
        integerStuff();
        doubleStuff();
        floatStuff();
//        characterStuff();
    }

    private static void booleanStuff() {
        System.out.println("###### booleanStuff");

        boolean thisIsFalse = false;
        boolean thisIsTrue = true;
        assert ! thisIsFalse;
        assert thisIsTrue;
        assert thisIsFalse || thisIsTrue;
        assert ! thisIsFalse && thisIsTrue;
        assert thisIsFalse ^ thisIsTrue;
        assert Boolean.parseBoolean("true");
        assert Boolean.FALSE == false;
        assert Boolean.valueOf("falseeeee") == Boolean.FALSE;
    }

    private static void byteStuff() {
        System.out.println("###### byteStuff");
        System.out.println("Byte.BYTES " + Byte.BYTES);
        System.out.println("Byte.size " + Byte.SIZE);

        //#### READ / WRITE I/O
        String src = ""; //TODO YOUR_SRC_FILE_HERE
        String dest = "";  //TODO YOUR_DEST_FILE_HERE
        //Buffering avoid to much disk I/O, even if we grab the bytes one by one.
        try (InputStream in = new BufferedInputStream(new FileInputStream(src));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {
            int b;
            System.out.println("I'm reading...");
            while((b = in.read()) >= 0) {
                System.out.print(b);
                out.write(b);
            }
        } catch (Exception ex) {
           System.out.println("The copy failed :-(");
            ex.printStackTrace();
        }
    }

    private static void integerStuff() {
        System.out.println("###### integerStuff");
        System.out.println("Integer.BYTES " + Integer.BYTES);
        System.out.println(Integer.valueOf("12"));
        System.out.println(Integer.toString(11, 16)); //11 base16

        // The number 26, in decimal
        int decVal = 36;
//  The number 26, in hexadecimal
        int hexVal = 0x24;
// The number 26, in binary
        int binVal = 0b100100;
        System.out.printf("decVal %d hexVal %d binVal %d%n", decVal, hexVal, binVal);

        Integer a = 1;
        Integer b = 1;
        Integer c = new Integer(1);
        Integer e = 128;
        Integer f = 128;

        assert a == b; // Java pool of integer, often -128 / 127 , platform dependant
        assert a != c; // new Integer => not inside the pool
        assert e != f; // 128 often outside of the pool
    }

    private static void longStuff() {
        System.out.println("###### longStuff");
        Long value = new Long(0);
        System.out.println(value.equals(0));

        //from Java 7, underscore are authorized
        long siret = 795_123_456_12345L;
        System.out.println(siret);
    }

    private static void doubleStuff() {
        System.out.println("###### doubleStuff");
        System.out.println("Double.BYTES " + Double.BYTES);
        System.out.printf("MIN_VALUE %s / MAX_VALUE %s / NaN %s / NEGATIVE_INFINITY %s / POSITIVE_INFINITY %s %n", Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

        //Don't compare floating points for equality, can't assume the number  assigned to the float or double is represented exactly
        //see http://docs.oracle.com/cd/E19957-01/806-3568/ncg_goldberg.html
        //see http://floating-point-gui.de
        // Use BigDecimal if you need precision http://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html
        System.out.println("2.2f == 2.2 " + (2.2f == 2.2 ? "same" : "different")); // 3.2 is NOT represented exactly
        System.out.println("2.5f == 2.5 " + (2.5f == 2.5 ? "same" : "different")); // 2.5 is represented exactly

        System.out.printf("%s%n", 0.1); // why does 0.1 doesn't exists in Floating Point http://www.exploringbinary.com/why-0-point-1-does-not-exist-in-floating-point/
        System.out.printf("%f%n", 0.1);
        System.out.printf("%.2f%n", 0.1);
        System.out.printf("%.40f%n", 0.1);
        System.out.println(new BigDecimal(0.1));
        System.out.printf("%.17f%n", 0.1 + 0.1 + 0.1);
        System.out.println((new BigDecimal(0.1)).add(new BigDecimal(0.1)).add(new BigDecimal(0.1)));
        System.out.println((new BigDecimal("0.1")).add(new BigDecimal("0.1")).add(new BigDecimal("0.1")));

    }

    private static void floatStuff() {
        System.out.println("###### floatStuff");
        System.out.println("Float.BYTES " + Float.BYTES);
        // float f = 2.2; // beware, by default, it' double
        float f = 2.2f;
        String consts = String.format("MIN_VALUE %s / MAX_VALUE %s / NaN %s / NEGATIVE_INFINITY %s / POSITIVE_INFINITY %s", Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
        System.out.println(consts);
    }

    private static void characterStuff() {
// From http://docs.oracle.com/javase/7/docs/technotes/guides/intl/overview.html
// The Java programming language is based on the Unicode character set, and several libraries implement the Unicode standard.
// Unicode is an international character set standard which supports all of the major scripts of the world,
// as well as common technical symbols.
// The original Unicode specification defined characters as fixed-width 16-bit entities,
// but the Unicode standard has since been changed to allow for characters whose representation requires more than 16 bits.
// The range of legal code points is now U+0000 to U+10FFFF.
// An encoding defined by the standard, UTF-16, allows to represent all Unicode code points using one or two 16-bit units.
// The primitive data type char in the Java programming language is an unsigned 16-bit integer that can represent a Unicode code point in the range U+0000 to U+FFFF, or the code uits of UTF-16.
// The various types and classes in the Java platform that represent character sequences - char[], implementations of java.lang.CharSequence (such as the String class), and implementations of java.text.CharacterIterator - are UTF-16 sequences.
// Most Java source code is written in ASCII, a 7-bit character encoding, or ISO-8859-1, an 8-bit character encoding, but is translated into UTF-16 before processing.
// The Character class as an object wrapper for the char primitive type.
// The Character class also contains static methods such as isLowerCase() and isDigit() for determining the properties of a character.
// Since J2SE 5, these methods have overloads that accept either a char (which allows representation of Unicode code points in the range U+0000 to U+FFFF) or an int (which allows representation of all Unicode code points).


        //By the way, interesting things to know http://programmers.stackexchange.com/questions/174947/why-does-java-use-utf-16-for-internal-string-representation
        System.out.println("###### characterStuff");

        // a char is always 2 bytes long in Java. But sometimes we need two UTF-16 code points to represent one Unicode code point
        // Java String will use 2 chars for such one character, see this answer http://stackoverflow.com/a/5078365
        System.out.println("Character use " + Character.SIZE  + " bits");

        System.out.println("你好");
        System.out.println("\u4F60\u597D");
        char[] nihao = new char[2];
        nihao[0] = '\u4F60';
        nihao[1] = '\u597D';
        System.out.println(nihao);
        String 你好 ="你好";
        System.out.println(你好);

        System.out.println("UTF-8");
        for(Byte b: 你好.getBytes(StandardCharsets.UTF_8)) {
            System.out.print(b);
        }

        System.out.println("\nUTF-16");
        for(Byte b: 你好.getBytes(StandardCharsets.UTF_16)) {
            System.out.print(b);
        }

        System.out.println("\nPlaying with N.IO ByteBuffer encode/decode and Charsets");
        // can also create a new Charset and use one of the standards encoding http://docs.oracle.com/javase/7/docs/technotes/guides/intl/overview.html
        Charset utf8 = StandardCharsets.UTF_8;
        // String internal representation is char so it's UTF-16, but we can convert 你好 back and forth to UTF-8
        ByteBuffer bybu = ByteBuffer.wrap(你好.getBytes(StandardCharsets.UTF_8));
        System.out.println(utf8.decode(bybu).toString());


        try {
            CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
            // Using CharsetEncoder / Decoder we gain more fine grain control on how to convert the strings
            // that the String.getBytes methods that will use ? to mark encoding/decoding problems
            encoder.onMalformedInput(CodingErrorAction.IGNORE);

            ByteBuffer bb = encoder.encode(CharBuffer.wrap(你好));

            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder(); // supported encodings http://docs.oracle.com/javase/7/docs/technotes/guides/intl/overview.html
            decoder.onMalformedInput(CodingErrorAction.IGNORE);
            CharBuffer cb = decoder.decode(bb);

            System.out.println(cb.toString());

        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }

    }
}
