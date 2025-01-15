package com.demat.starter;

import java.io.*;

/**
 * @author TNAJI Khalid
 */
public class Chap20IO {
    public static void Demo() {
        /*
        Abstract class: InputStream
• Low-level class: FileInputStream
• reads one byte at a time
• High-level class (for eciency): BufferedInputStream
• High-level class (other): ObjectInputStream
• Wrapping example:
         */
        try {
            new ObjectInputStream(new FileInputStream("file.dat"));
            new ObjectInputStream(new BufferedInputStream(new FileInputStream("file.dat")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        Abstract class: Reader
• Low-level class: FileReader
• High-level class (for eciency): BufferedReader
• High-level class (other): InputStreamReader
• a bridge between byte streams and character streams

        • Wrapping examples:
         */
        try {
            new BufferedReader(new FileReader("in.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        new BufferedReader(new InputStreamReader(System.in));


        // example: copy text file (no buffering)
        File srcFile = new File("C:\\Users\\Luka\\MyIOFiles\\source.txt");
        File destFile = new File("C:\\Users\\Luka\\MyIOFiles\\destination.txt");
        try(var reader = new FileReader(srcFile);
            var writer = new FileWriter(destFile)) {
            int c;
            while ((c = reader.read()) != -1) {// reads character
                writer.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // example: copy text file (with buffering, same files)
        try(var reader = new BufferedReader(new FileReader(srcFile));
            var writer = new BufferedWriter(new FileWriter(destFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();//we use newLine() because readLine() strips out the end-of-line character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // example: copy binary file (no buffering)
        try(var in = new FileInputStream(srcFile);
            var out = new FileOutputStream(destFile)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // example: copy binary file (with buffering, same files)
        try(var in = new BufferedInputStream(new FileInputStream(srcFile));
            var out = new BufferedOutputStream(new FileOutputStream(destFile))) {
            var buffer = new byte[1024];
            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
                out.flush();//used if we want to ensure the data is written immediately
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        ///
        //
         /*
         Console Class
• class java.io.Console is designed for interacting with the user
• this class is a singleton
• using factory method we create one and only instance of this class
• the constructors of Console class are private
• i.e. created using factory methods, not with new keyword
          */

        Console console = System.console();
        String name = console.readLine();
        console.format(name);
        console.writer().println("Hello World!");
    }
}
