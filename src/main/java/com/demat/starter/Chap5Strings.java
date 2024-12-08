package com.demat.starter;

/** Chap 5 */
public class Chap5Strings {

    public static void main(String[] args) {
        // strip(), trim(), stripLeading(), stripTrailing()
        String str = " abc ";
        System.out.println("|" + str.strip() + "|");
        // |abc|
        System.out.println("|" + str.trim() + "|");
        // |abc| // same as strip, but supports Unicode
        System.out.println("|" + str.stripLeading() + "|");
        // |abc |
        System.out.println("|" + str.stripTrailing() + "|");
        // | abc|
        // whitespaces also includes \t (tab), \n (new line), \r (carriage return)
        // all escape sequences count as one character in length
        System.out.println("|" + "\t abc\t".strip() + "|");
        //abc


        /*
        indent(n) method
        • if n = 0 does nothing
        • if n > 0 adds the same number of blank spaces to each line
        • if n < 0 tries to remove n whitespace characters from the beginning of line
        • normalizes existing line breaks
        • adds line break at the end if missing

        stripIndent() method
        • removes all leading incidental whitespace
        • normalizes existing line breaks
        • does not add line break at the end if missing
         */

        System.out.println("***********************+");
        str = " John\n D.\n Wayne";
        System.out.println("--");
        System.out.println(str);
        System.out.println("--");
        System.out.println(str.indent(2));
        System.out.println("--");
        System.out.println(str.indent(-2));
        System.out.println("--");
        System.out.println(str.stripIndent());
        System.out.println("--");


        System.out.println("********* translateEscapes **************");
        // translateEscapes();
        String name = "John\\tWayne";
        System.out.println(name);
        //John\tWayne
        System.out.println(name.translateEscapes());
        // John Wayne

        System.out.println("***********************************");

        System.out.println("".isEmpty());
        // true
        System.out.println(" ".isEmpty());
        // false
        System.out.println("".isBlank());
        // true
        System.out.println(" ".isBlank());
        // true

        /*
        %f for decimal numbers (float and double)
        %n inserts a system-dependent line separator
         */

        System.out.println("**********************************");
        String s1 = "John";
        String s2 = " John ".trim();
        System.out.println(s1 == s2);
        // false
        // pool is created at compile-time, and trim() is evaluated at run-tim

         s1 = "John Wayne";
         s2 = "John" + " " + "Wayne";
        System.out.println(s1 == s2);
        //true
        // concatenation is done in the compile-time
        // compiler now knows that these are the same literals


        // you can instruct the compiler to use the pool even with runtime methods
        s1 = "John";
        s2 = " John ".trim().intern();
        System.out.println(s1 == s2);
        // true

        // if you don't want the compiler to use the pool
        // you can achieve this but creating a new object with keyword "new"
         name = "John Wayne";
         var theName = new String("John Wayne");
        System.out.println(name == theName); // false

        // StringBuilder is a mutable class which contains a String
        // substring() returns a String and doesn't change the StringBuilder
        //// StringBuilder doesn't implement equals() method!!
        StringBuilder sbName1 = new StringBuilder("John Wayne");
        StringBuilder sbName2 = new StringBuilder("John Wayne");
        System.out.println(sbName1 == sbName2);
        //false
        /*
        insert
        delete
        deleteCharAt
        reverse
         */
    }
}
