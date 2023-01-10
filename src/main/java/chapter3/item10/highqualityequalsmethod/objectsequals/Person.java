package chapter3.item10.highqualityequalsmethod.objectsequals;

import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person p = (Person) o;

        // Compare fields using the Objects.equals method
        return Objects.equals(name, p.name) && age == p.age;
    }
}