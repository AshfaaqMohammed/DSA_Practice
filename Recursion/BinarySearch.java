package Recursion;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(BSearch(array,5,0,array.length));
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
