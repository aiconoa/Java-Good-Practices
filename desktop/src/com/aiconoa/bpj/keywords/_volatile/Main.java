package com.aiconoa.bpj.keywords._volatile;

/**
 * Borrowed from http://stackoverflow.com/questions/17748078/simplest-and-understandable-example-of-volatile-keyword-in-java
 * Created by thomasgros on 2/23/14.
 */
public class Main extends Thread{
    volatile boolean keepRunning = true;

    public void run() {
        long count=0;
        while(keepRunning) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Main m = new Main();
        m.start();
        Thread.sleep(1000);
        m.keepRunning = false;
        System.out.println("keepRunning set to false");
    }
}
