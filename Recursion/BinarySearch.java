package Recursion;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2,4,5,7,8,9,12,14,17,19,22,25,27,28,33,37};
        System.out.println(BSearch(array,22,0,array.length));
    }
    public static int BSearch(int[] array,int ele,int l, int h){
        if (l > h){
            return -1;
        }else{
            int mid = (l+h)/2;
            if (ele == array[mid]){
                return mid;
            }else if (ele < array[mid]){
                return BSearch(array,ele,l,mid-1);
            }else{
                return BSearch(array,ele,mid+1,h);
            }
        }
    }
}
