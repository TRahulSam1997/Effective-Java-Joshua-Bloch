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

        /** Compare fields using the Objects.equals() method. */
        return Objects.equals(name, p.name) && age == p.age;

        /**
         * "The Objects.equals() method is a utility method provided by the java.util.Objects class in Java.
         * It can be used to compare the equality of two objects, taking into account that either or both objects can be null.
         * The method will return true if both objects are null,
         * or if the objects are non-null and the equals method of the first object returns true when called with the second object as the argument."
         * - ChatGPT
         */
    }

    public static void main(String[] args) {
        Person p1 = new Person("John", 25);
        Person p2 = new Person("John", 25);
        Person p3 = new Person("Jane", 25);
        Person p4 = new Person(null, 25);

        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.equals(p3)); // false
        System.out.println(p1.equals(p4)); // false

    }
}