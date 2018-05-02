package com.cfsa.qa.tests;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ashutoks on 01/08/17.
 */
public class Practice {

    public static void main(String arg[]) {

        int number = 10;
        Practice p = new Practice();
        //p.fizzBuzz();
        //p.reverseWordString();
        //p.reversString();
//        for(int i=1; i<=number; i++)
//
//        {
//            //System.out.print(p.fiboniSeries(i) +" "); }
//
//    }
        //System.out.println(p.fionaciSeries(10));
        //System.out.println(p.reverseNumber(101));
        //System.out.println(p.fact(5));
        //System.out.println(p.recursiveFactorial(6));
        //System.out.println(p.checkPrimeNum(5));
        //System.out.println(p.isArmStrongNumber(153));
        // p.swapNumber(10, 20);
        // p.reverseNum(325);
       // p.reverseArrayList();
       // p.permutationofStrings("","abc");
        p.combinationnofStrings("","abc");
    }


    public void fizzBuzz() {

        for (int i = 1; i <= 50; i++) {
            if (i % (3 * 5) == 0)
                System.out.println("FizzBuzz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else System.out.println(i);
        }
    }

    public void reverseWordString() {

        String name = "Ashutosh kumar singh";

        String[] rev = name.split(" ");
        String reverString = "";

        for (int i = 0; i <= rev.length - 1; i++) {
            String word = rev[i];
            String revword = "";

            for (int j = word.length() - 1; j >= 0; j--) {

                revword += word.charAt(j);
            }
            reverString += revword;
        }
        System.out.println(reverString);
    }

    public void reversString() {

        String name = "Ashutosh";
        String reversName = "";

        for (int i = name.length() - 1; i >= 0; i--) {

            reversName += name.charAt(i);
        }

        System.out.println(reversName);
    }

    public int fiboniSeries(int num) {


        if (num == 1 || num == 2) {
            return 1;
        } else {
            return fiboniSeries(num - 1) + fiboniSeries(num - 2);

        }
    }

    public ArrayList fionaciSeries(int num) {

        int fibo1 = 1;
        int fibo2 = 1;
        int fibonaci = 1;
        ArrayList<Integer> series = new ArrayList<Integer>();


        for (int i = 1; i <= num; i++) {

            if (i == 1 || i == 2) {
                series.add(fibonaci);
            } else {
                fibonaci = fibo1 + fibo2;
                fibo1 = fibo2;
                fibo2 = fibonaci;
                series.add(fibonaci);
            }
        }
        return series;
    }


    public int reverseNumber(int num) {

        int reverse = 0;
        int reminder = 0;

        do {

            reminder = num % 10;
            reverse = reverse * 10 + reminder;
            num = num / 10;

        }
        while (num > 0);
        return reverse;
    }

    public int fact(int num) {

        int result = 1;
        while (num != 0) {

            result = result * num;

            num--;
        }
        return result;
    }

    public int recursiveFactorial(int num) {

        if (num == 0) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }

    public boolean checkPrimeNum(int num) {

        for (int i = 2; i < num; i++) {

            if (num % i == 0) {

                return false;
            }
        }
        return true;

    }

    public boolean isArmStrongNumber(int num) {

        int res = 0;
        int reminder = 0;
        int origNum = num;

        do {

            reminder = num % 10;
            res += Math.pow(reminder, 3);
            num = num / 10;
        }
        while (num > 0);
        if (res == origNum) {
            return true;
        }
        return false;
    }

    public void swapNumber(int num1, int num2) {

        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println(num1);
        System.out.println(num2);
    }

    public void reverseNum(int num) {

        int rem = 0;
        int rev = 0;
        while (num > 0) {

            rem = num % 10;
            num = num / 10;
            rev = rev * 10 + rem;

        }


        System.out.println(rev);

    }

    public void reverseArrayList() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int j = list.size() - 1;
        for (int i = 0; i <= j; i++) {
            list.add(i, list.remove(j));

        }
        System.out.println(list);
    }

    public void permutationofStrings(String prefix, String str){

        if(str.length()==0){
            System.out.println(prefix);
        }
        else {

            for(int i=0; i<str.length(); i++){

                permutationofStrings(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length()));
            }
        }
    }

    public void combinationnofStrings(String prefix, String str){

        if(str.length()==0){
            System.out.println(prefix);
        }
        else {

            for(int i=0; i<str.length(); i++){

                combinationnofStrings(prefix+str.charAt(i),str.substring(i+1));
            }
        }
    }


}
