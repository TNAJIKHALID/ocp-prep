package com.demat.starter;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author TNAJI Khalid
 */
public class Chap9ClassDesign {
    public static void main(String[] args) {

        /*
            What happens when we initialize a class?
            1. If there is a superclass, it is initialized first
            2. All static variables are processed (in order of appearance)
            3. All static initializers are are processed (in order of appearance)
         */

        /*
        What happens when we initialize an instance of a class?
        1. Initialize the class if it was not already initialized (see previous slides)
        2. If there is a superclass, initialize superclass.
        3. Process all instance variable declarations.
        4. Process all instance initializers.
        5. Initialize the constructor.
         */

        /*
        class A {
            public void greet() throws IOException { }
            public void sayHello() { }
            public void leave() {} throws FileNotFoundException {}
        }
        public class B extends A {
            public void greet() throws FileNotFoundException { }
            public void sayHello() throws IOException { } //NOK
            public void leave() throws IOException { } //NOK
        }
         */
    }



}
