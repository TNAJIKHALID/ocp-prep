package com.demat.starter;

import java.util.*;

/**
 * @author TNAJI Khalid
 */
public class Chap12Collections {
    public static void main(String[] args) {

        /*
interface Deque implements Queue
• class LinkedList implements Queue and List
• interface Map doesn't implement Collection
• classes HashMap and ThreeMap implement Map interface
         */

// equals() method
// comparing the type and contents of the Collection
// implementations vary (ArrayList checks order, HashSet does not, etc.)


        /*
there are two classes which implement List interface:
• ArrayList and LinkedList
• ArrayList is better when you read more than you write
• LinkedList implements both List and Deque

1. Arrays.asList(varargs)
• fixed size list backed by an array
2. List.of(varargs)
• returns immutable list
3. List.copyOf(collection)
• immutable list with copy of original values
• when you create a List in this way, its sized is fixed (no adding or removing)
         */


        // backing up works both ways
        String[] names = new String[] {"John", "George", "Luke"};
        List<String> namesAsList = Arrays.asList(names);
        namesAsList.set(2, "Paul");
        System.out.println(namesAsList);
        //=> [John, George, Paul]
        System.out.println(Arrays.toString(names));
        //=> [John, George, Paul]
// when you have a list backed by the array (Arrays.asList)
// then change in one results with change in another

        /*
        List Methods
add(E element)
add(int index, E element)
get(int index)
remove(int index)
remove(E element)
replaceAll(UnaryOperator<E> op)
set(int index, E element)
sort(Comparator<? super E> c)
         */

        List<Integer> myList = new ArrayList<>();
        myList.add(3);
        myList.add(5);
        myList.add(7);
        Object[] objArray = myList.toArray(); //array of Objects in the list
        Integer[] intArray = myList.toArray(new Integer[0]);



        // FIFO
        /*
 proper methods
• peek(), offer(E e), poll()
• methods inherited from Collection
• element(), add(E e), remove()
         */
        Queue<String> colors = new LinkedList<>();
        colors.offer("blue");
        colors.offer("green");
        colors.offer("red");
        colors.offer("yellow");
        System.out.println(colors);
        System.out.println(colors.peek());// retrun the elemet to poll without deleting it
        colors.poll();// retrun the elemet to poll and deleting it
        System.out.println(colors);
        System.out.println(colors.peek());



        // LIFO
        //implemented by LinkedList and ArrayQueue
        //peek(), push(E e), poll()
        Deque<String> colors2 = new ArrayDeque<>();
        colors2.push("blue");
        colors2.push("green");
        colors2.push("red");
        colors2.push("yellow");
        System.out.println(colors2);
        System.out.println(colors.peek());
        colors2.pop();// rmoveFirst
        System.out.println(colors2.peek());

        // must be implemented
        var d = new Comparable<String>(){
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };


        var dd = new Comparator<String>() {
            public int compare (String p1, String p2) {
                return 0;
            }
        };

        Comparator<? super String> comparator = dd;
        colors2.stream().sorted(comparator);


    }
}
