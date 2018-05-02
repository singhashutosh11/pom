package com.cfsa.qa.tests;

/**
 * Created by ashutoks on 03/08/17.
 */
class NameThreads implements Runnable {
    public void run() {
        System.out.println("NameRunnable running");
        System.out.println("Run by "
                + Thread.currentThread().getName());
    }
}

public class Threads {
    public static void main (String [] args) {
        NameThreads nr = new NameThreads();
        Thread t = new Thread(nr);
       // t.setName("Fred");
        t.start();
    } }