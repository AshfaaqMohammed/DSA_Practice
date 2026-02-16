package Recursion;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciBad(12));
        System.out.println(Arrays.toString(fibonacciGood(12)));
    }

    public static int fibonacciBad(int n){
        if (n <=1){
            return n;
        }
        return fibonacciBad(n-1) + fibonacciBad(n-2);
    }

    public static long[] fibonacciGood(int n){
        if (n <= 1){
            return new long[]{n,0};
        }
        else{
            long[] temp = fibonacciGood(n-1);
            return new long[]{temp[0]+temp[1],temp[0]};
        }
    }
}
