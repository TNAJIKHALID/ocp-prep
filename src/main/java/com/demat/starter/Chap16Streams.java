package com.demat.starter;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
* @author TNAJI Khalid
*/
public class Chap16Streams {
    public static void main(String[] args) {
        System.out.println(Optional.empty());
        //Optional.empty

        Optional<Double> myEmptyOptional = Optional.empty();
        System.out.println(myEmptyOptional.get());
        //NoSuchElementException

        //orElseThrow() throws NoSuchElementException


        // parallel stream (operations are done in parallel rather then in sequence)
        Stream<String> fromListParallel = List.of("Hello").parallelStream();


        // creating infinite streams
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        // these streams are infinite, they generate values ad infinitum

        //randoms.forEach(System.out::println);
        //program prints random numbers until you kill it


        // operations like limit() can turn infinite stream to finite one
        Stream<Double> limited = randoms.limit(79);


        //Stream.iterate(seed, predicate,unaryOperator)
        Stream<Integer> oddNumbersUnder50 = Stream
                .iterate(1, n -> n < 50, n -> n + 2);


        // All these methods terminates the finite stream
        //When applied on infinite stream Re Does not terminate:
        //count, (min, max <= Optional<T>) forEach, collect, reduce

        // any/all/non Match terminates the infinite stream if the value is true

        //When applied on infinite stream Does terminate:
        //findAny findFirst <= Optional<T>


        Stream<Integer> s = Stream.of(1, 2, 3);
        //NOK cant use for loop on stream
        for (Integer i : s) {
            // do something
        }


        // same thing using streams
        Stream<String> myStream = Stream.of("L", "u", "k", "e");
        // with identity
        String myName = myStream.reduce("", (ss, c) -> ss + c);
        String myName2 = myStream.reduce("", String::concat);

        // without identity
        Optional<?> myName3 = myStream.reduce(String::concat);
        Optional<String> myName35 = myStream.reduce(String::concat);



        Stream<String> names = Stream.of("John", "George", "Ben");
                            //initializer, //accumulator                            // combiner
        int len = names.reduce(0, (i, sw) -> i + sw.length(), (a, b) -> a + b);


        Stream<String> myStream22 = Stream.of("L", "u", "k", "e");
        TreeSet<String> mySet1 = myStream.collect(
                TreeSet::new, //supplier, creates an empty TreeSet
                TreeSet::add, //accumulator, adds a single String from Stream to TreeSet
                TreeSet::addAll); //combiner, adds all elements of one TreeSet to another
        TreeSet<String> mySet = myStream22.collect(Collectors.toCollection(TreeSet::new));
        // treeSet orderd Asc
        // Set not orderd
        Set<String> mySet3 = myStream.collect(Collectors.toSet());


        /*
        Intermediate Operations
• produces a stream as a result
can deal with innite streams
(by returning another innite stream)
• can be omitted in a pipeline
(unlike source and terminal operations)
         */

        //.filter, .distinct, .map, .sorted() Asc, .sorted(Comparator.comparingInt(String::length))
        // restricting by position
        Stream<Integer> numbers = Stream.iterate(1, n -> n + 1);
        names.skip(3)
                .limit(4)
                .forEach(System.out::print);
        //4567
        List<String> zero = List.of();
        List<String> one = List.of("John");
        List<String> two = List.of("George", "Ben");
        Stream<List<String>> names33 = Stream.of(zero, one, two);
        List<String> list = names33.flatMap(m -> m.stream()).toList();
        //John
        //George
        //Ben


        // Premitive Streams
        /*
          IntStream - used for int, short, byte and char
        • LongStream - used for long
        • DoubleStream - used for double and float
        • only difference is that primitive streams have some unique methods
         */

        //LongStream range(long a, long b) b excluded
        //LongStream rangeClosed(long a, long b) b included

        //Int/Long/DoubleSummaryStatistics summaryStatistics() =>  (avg, min, max, count.)ç



        IntStream intStream = IntStream.of(7, 11, 21);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble());

        // example of mapping
        //Stream<T> using mapToDouble() returns DoubleStream

        var myIntStream = IntStream.rangeClosed(2, 7);
        OptionalDouble myAvg = myIntStream.average();
        System.out.println(myAvg.getAsDouble());
        System.out.println(myAvg.orElseGet(() -> Double.NaN));

        // todo collecting result
    }
}
