package com.random.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * Created by pr250155 on 4/3/17.
 */
public class LambdasTest {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("Prithwin","Male",30),
                new Person("Prithwin1","Male",31),
                new Person("Prithwin2","Male",32),
                new Person("Prithwin3","Male",33),
                new Person("Prithwin3","Male",34));

        System.out.println(persons.stream().
                collect(groupingBy(p -> p.name,mapping(p -> p.age, toList())))
        );
    }

}

class Person {
    String name;
    String gender;
    int age;

    public Person(String prithwin, String male, int i) {
        this.name = prithwin;
        this.gender = male;
        this.age = i;
    }
}
