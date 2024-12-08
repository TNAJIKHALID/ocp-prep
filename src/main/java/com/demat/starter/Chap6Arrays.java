package com.demat.starter;

import java.util.Arrays;

/** Chap 6 */
public class Chap6Arrays {
    public static void main(String[] args) {
        /*
        int[] nums;
        int [] nums;
        int []nums;
        int nums[];
        int nums [];
     */

        // you can have multiple values in one declaration
        int[] myNumbers, myIntValues;
        int myNumbers1[], a;
        // arrays don't implement equals() method

        // printing out the array
        int[] nums = new int[] {3, -1, 17};
        System.out.println(nums);
        //[I@7a4f0f29
        System.out.println(Arrays.toString(nums));
        //[3, -1, 17]

        // every array has a property called "length" not a method

        // NOTE: arrays are mutable, sort() changes the original array!
        //Arrays.sort()
/*

            Arrays.binarySearch()
           works only on sorted arrays
          if array is not sorted, the result is unpredictable
 */


        /*
          Arrays.compare()
        • determines which array is "smaller" and returns:
        • negative number if first is smaller then second
        • zero if the arrays are equal in content
        • positive number if first is larger than second

        for Strings:
        • one is smaller if it's a prefix of another
        • numbers are smaller than letters
        • uppercase is smaller than lowercase
        • alphabetical order is applied
         */

        // Arrays.mismatch()
        // returns -1 if arrays are equal, otherwise the first index where they differ
    }
}
