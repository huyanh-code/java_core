package stream;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

public class javaStream {
    public static void main(String[] args) {
//        primitiveStreamExample();
//        streamFromArray();
//        streamFromCollection();
//        streamUsingRegex();
//        getCollectionUsingStreamCollection();
//        getArrayUsingStreamToArray();
//        forEachStreamExample();
//        minMaxStream();
//        intSummaryStatisticsExample();


    }

    private static void intSummaryStatisticsExample() {
        List<Integer> primes = Arrays.asList(2,3,4,5,6,10);

        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
    }

    private static void minMaxStream() {
        List<Progamming> students = Arrays.asList(
                new Progamming("Java", 5),
                new Progamming("PHP", 2),
                new Progamming("C#", 1)
        );

        Progamming maxByExp = students.stream()
                .max(Comparator.comparing(Progamming::getExp))
                .get();
        Progamming minByExp = students.stream()
                .min(Comparator.comparing(Progamming::getExp))
                .get();

        System.out.println("Max: " + maxByExp);
        System.out.println("Min: " + minByExp);
    }

    private static void forEachStreamExample() {
        Stream.iterate(1, count -> count + 1)
                .filter(number -> number % 3 == 0)
                .limit(6)
                .forEach(System.out::println);
    }

    private static void getArrayUsingStreamToArray() {
        Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript");
        String[] language =  stream.toArray(String[]::new);
        System.out.println(Arrays.toString(language));
    }

    private static void getCollectionUsingStreamCollection() {
        Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript");
        List<String> language = stream.collect(Collectors.toList());
        System.out.println(language);
    }

    private static void streamUsingRegex() {
        // Generate Streams from APIs like Regex
        String str = "Welcome, to, regex";
        Pattern.compile(",").splitAsStream(str).forEach(System.out::print);
    }

    private static void streamFromCollection() {
        // Generate Streams from Collections
        List<String> items = new ArrayList<>();
        items.add("Java");
        items.add("C#");
        items.add("C++");
        items.add("PHP");
        items.add("Javascript");

        items.stream().forEach(item -> System.out.println(item));
    }

    private static void streamFromArray() {
        String[] languages = {"Java", "C#", "C++", "PHP", "Javascript"};

        // Get stream using the Arrays.stream
        Stream<String> testStream1 = Arrays.stream(languages);
        testStream1.forEach(x -> System.out.println(x));

        // Get stream using the Stream.of
        Stream<String> testStream2 = Stream.of(languages);
        testStream2.forEach(x -> System.out.println(x));
    }

    private static void primitiveStreamExample() {
        IntStream.range(1, 4).forEach(System.out::println);
        IntStream.of(5,6,7).forEach(System.out::println);
        DoubleStream.of(1,2,3).forEach(System.out::println);
        LongStream.range(1,4).forEach(System.out::println);
    }
}
