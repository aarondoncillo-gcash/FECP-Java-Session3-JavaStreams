package org.example;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    Person() {

    }
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}

public class JavaStreams {

    public static void main(String[] args) {


        // Activity 1: Filter Odd Numbers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10); //generate a list of numbers from 1 to 10
        Predicate<Integer> isOdd = n -> n % 2 == 1; // predicate for filtering odd numbers
        List<Integer> result = numbers.stream().filter(isOdd).collect(Collectors.toList()); //filter odd numbers and return a list
        System.out.println("Activity 1: Filter Odd Numbers");
        System.out.println("Odd numbers: " + result);

        // Activity 2: Filter Strings Starting with 'A'
        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian"); //generate a list of names
        Predicate<String> startsWithA = s -> s.startsWith("A"); //predicate for filtering names starting with A
        List<String> result2 = names.stream().filter(startsWithA).toList(); //filter names starting with A
        System.out.println("Activity 2: Filter Strings Starting with 'A'");
        System.out.println("Names starting with A: " + result2);

        // Activity 3: Square All Numbers
        List<Integer> numbers3 = Arrays.asList(1,2,3,4,5); //generate a list of numbers from 1 to 5
        List<Integer> result3 = numbers3.stream().map(n -> n * n).toList(); //mapping of each number to get the square
        System.out.println("Activity 3: Square All Numbers");
        System.out.println("Squared numbers: " + result3);

        //Activity 4: Combine Predicates
        List<Integer> numbers4 = Arrays.asList(1,2,3,4,5,6,7,8,9,10); //generate a list of numbers from 1 to 10
        Predicate<Integer> isEven = n -> n % 2 == 0; //predicate for filtering even numbers
        Predicate<Integer> greaterThanFive = n -> n > 5; //predicate for filtering numbers greater than 5
        List<Integer> result4 = numbers.stream().filter(isEven.and(greaterThanFive)).collect(Collectors.toList()); //filter and return a list of numbers that are both even and greater than 5
        System.out.println("Activity 4: Combine Predicates");
        System.out.println("Even and >5: " + result4);

        //Activity 5: Sort Objects Using Comparator
        System.out.println("\nActivity 5: Sort Objects Using Comparator");
        List<Person> people = Arrays.asList(
                new Person("Ben", 20),
                new Person("Mike", 25),
                new Person("John", 18),
                new Person("Zara", 29),
                new Person("Anna", 22)
        );
        //Sort by Age (Ascending Order)
        Comparator<Person> byAge = (p1, p2) -> p1.getAge() - p2.getAge(); //sort by age in ascending order
        System.out.println("Sorted by age (ascending):");
        people.stream().sorted(byAge).toList().forEach(System.out::println);


        //Sort by Name (Alphabetical Order)
        Comparator<Person> byName = (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()); //sort by name in ascending order
        System.out.println("\nSorted by name");
        people.stream().sorted(byName).toList().forEach(System.out::println);

        //Sort by Age (Descending Order)
        Comparator<Person> byAgeDesc = (p1, p2) -> p2.getAge() - p1.getAge(); //sort by age in descending order
        System.out.println("\nSorted by age (descending):");
        people.stream().sorted(byAgeDesc).toList().forEach(System.out::println);


    }
}