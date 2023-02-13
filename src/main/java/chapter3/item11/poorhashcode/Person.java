package chapter3.item11.poorhashcode;

public class Person {
    private final String firstName;
    /** lastName is a significant field yet not used in hashCode() */
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return firstName.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return firstName.equals(other.firstName) && age == other.age;
    }
}

/**
 * "If we create a large collection of Person objects that differ mainly in their lastName field,
 * the hash function implemented in the Person class will be of poor quality, and the hash-based data structures that use it will experience many collisions.
 * This can lead to poor performance and even cause programs that should run in linear time to run in quadratic time." - ChatGPT
 */