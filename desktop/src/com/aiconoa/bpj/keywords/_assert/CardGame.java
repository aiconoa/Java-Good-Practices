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

package com.aiconoa.bpj.keywords._assert;

import java.util.ArrayList;
import java.util.List;

public class CardGame {

    private List<Card> deck;

    public CardGame() {
        deck = new ArrayList<Card>();
        // build the card game with some default
    }

    private void shuffle() {
        // do some crazy stuff
        deck.add(new Card()); // I'm not cheating, the algorithm is really complex and I've written buggy code :-(
    }

    public void distributeHands() {

        // do some work here
        // ...
        //numberOfCards is an invariant http://en.wikipedia.org/wiki/Invariant_(computer_science)
        int numberOfCards = deck.size();
        shuffle();
        assert numberOfCards == deck.size(): "Shuffling should never change the number of cards";
        // do some other work here
        //...
    }
}