package imperative;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John",MALE),
                new Person("maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)

        );

        System.out.println("imperative approach");

        List<Person> females = new ArrayList<>();

        for(Person person : people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for(Person female : females){
            System.out.println(female);
        }

        //declarative approach
        System.out.println("declarative approach");
        people.stream()
                .filter(person->FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println) ;

        List<Person> females2 = people.stream().
                filter(person->FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);


    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person( String name, Gender gender){

            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return name+":" +gender;
        }
    }

     enum Gender{
        MALE, FEMALE
     }

}
