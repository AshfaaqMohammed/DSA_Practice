package Recursion;

import java.util.Arrays;

public class Rough {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,88};
        reverse(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void reverse(int[] array, int low, int high){
        if (low < high){
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            reverse(array,low+1,high-1);
        }
    }
}