package com.java.rules;

import com.personal.util.TreeNode;
import scala.Int;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by prajeeva on 11/4/17.
 */
public class StreamRules {
    private static class Person {
        String name;
        String race;
        int age;
        String country;

        public Person(String name, String race, int age, String country) {
            this.name = name;
            this.race = race;
            this.age = age;
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", race='" + race + '\'' +
                    ", age=" + age +
                    ", country='" + country + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
//        List<Person> persons = getListSoThatIcanSeggreagate();
//        System.out.println(persons.stream().collect(Collectors.groupingBy(o -> {
//            if(o.getAge() > 19) return "old";
//            else return "young";
//        })).entrySet().stream().filter(e -> e.getKey().equals("young")).map(e -> (long) e.getValue().size()).collect(Collectors.toList()));
//        System.out.println();
        Map<Integer , Integer> map = new HashMap<Integer, Integer>() {{
            put(1,5);
            put(7,5);
            put(2,3);
            put(3,1);
        }};

        String[] res = map.entrySet().stream().collect(Collectors.toMap(e -> e.getValue(), e -> e.getKey()+"" ,
                (e1,e2) -> e1+","+e2)).entrySet().stream().max(Comparator.comparing(Map.Entry::getKey)).get().getValue().split(",");

    }


    private static void p(List<Integer> list , Predicate<Integer> selector) {
        for(int n : list) {
            if(selector.test(n)) {
                System.out.println();
            }
        }
    }

    private static List<Person> getListSoThatIcanSeggreagate() {
        return Arrays.asList(
                new Person("Prithwin", "Indian", 15, "India"),
                new Person("theotherguy", "Indian", 16, "US"),
                new Person("moreguys", "Indian", 17, "India"),
                new Person("thatkindaguy", "Indian", 18, "US"),
                new Person("thiskindaguy", "Indian", 19, "US"),
                new Person("somekindaguy", "Indian", 20, "India"),
                new Person("guyswhosgodd", "Indian", 21, "India"),
                new Person("someohterkind", "Indian", 22, "US"),
                new Person("nathan", "Indian", 23, "US")
        );
    }
}
