package com.demat.starter;

/**
 * @author TNAJI Khalid
 */
public class Chap8Methods {
    public static void main(String[] args) {

        // you cannot pass an anonymous array (!)
        //greet("Hello", {"John", "George", "Luke"});  does not compile
        //greet("Hello", new String[] {"John", "George", "Luke"});ok


        //default(no keyword)
        //method or field can be accessed only within the same package

        // pow() is the static method, so we can use static import
        //import static java.lang.Math.pow;
        // => import must be at the beginning
        //static import java.lang.Math.pow; DOES NOT COMPILE


        /// ////////////////

        /*
        Boxing: converting a primitive into its wrapper class
        • (putting primitive in the "box")
        Unboxing: converting a wrapper class to a primitive
        • (getting a primitive out of the "box")
         */

        // explicit
        int a = 3;
        Integer b = Integer.valueOf(a);
        // int -> Integer (boxing)
        int c = b.intValue();
        // Integer -> int (unboxing)
        // implicit
        int a1 = 3;
        Integer b1 = a1;
        // int -> Integer (autoboxing)
        int c1 = b;
        // Integer -> int (unboxing)

        int x = 7;
        long y = x;
        // autocasting, OK
        //Long z = x;//NOK from int to Long
    }

}
