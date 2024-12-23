package com.demat.starter;

import java.util.*;

/**
 * @author TNAJI Khalid
 */
public class Chap13Exceptions {
    public static void main(String[] args) {
        //Checked Exception
        //• must be declared or handled by the application code where it is thrown

        /*
// examples of incorrect syntax:
catch (IOException e1 | NumberFormatException e2)
catch (IOException e | NumberFormatException e)
         */



        class  MyFileClass implements AutoCloseable {
            int p;
            MyFileClass(int p) {}

            @Override
            public void close() {
                System.out.println("closing MyFileClass #");
            }
        }

        try (MyFileClass bookReader = new MyFileClass(1);
             MyFileClass movieReader = new MyFileClass(2)) {
            System.out.println("try block");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
        }

        //when the exception occurs, first all the resources are closed (starting with the latest) 2 -> !,
        //and only then the program continues to be executed in a regular order

    }
}
