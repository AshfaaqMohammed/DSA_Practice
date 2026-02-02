package FundamentalDataStructures.sec35;

import java.util.Arrays;

public class EquivalenceTesting {
    /*
        - If a and b are reference variables, then expression a==b tests whether a and b refer to same object.
        - String.equals(String) checks for character for character equivalence.
        In Arrays - let say a and b are arrays
            - a == b -> tests if a and b refer to the same underlying array instance.
            - a.equals(b) is same as above one.
            - Arrays.equals(a,b) - it returns true if it has same length and same elements.
     */
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {1,2,3,4};
        System.out.println(arr1 == arr2); //---> it returns false
        System.out.println(Arrays.equals(arr1, arr2)); //----> it returns true

    }
}
