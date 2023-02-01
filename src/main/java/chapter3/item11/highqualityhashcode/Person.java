package chapter3.item11.highqualityhashcode;

import java.util.Objects;
import java.util.Arrays;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final int age;
    private final String[] languagesSpoken;

    Person(String firstName, String lastName, Address address, int age, String[] languagesSpoken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.languagesSpoken = languagesSpoken;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person other = (Person) o;
        return Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(address.getCanonicalAddress(), other.address.getCanonicalAddress());
    }

    @Override
    public int hashCode() {
        /** 17 is an arbitrary number picked as a constant to reduce collisions. */
        int result = 17;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        /** Checking if object is null and if not getting the canonical value. */
        result = 31 * result + Objects.hash(address != null ? address.getCanonicalAddress() : 0);
        result = 31 * result + Integer.valueOf(age).hashCode();
        /** We've assumed each field in the array is significant. */
        result = 31 * result + Arrays.hashCode(languagesSpoken);
        return result;
    }

    public static void main(String[] args) {
        Address camusAddress = new Address("Montmartre", "Paris", "Île-de-France", "75001");
        String[] camusLanguagesSpoken = {"English", "French", "Arabic"};
        Person albertCamus = new Person("Albert", "Camus", camusAddress, 46, camusLanguagesSpoken);
        System.out.println("Albert Camus hash code -> " + albertCamus.hashCode());
    }
}

class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    String getCanonicalAddress() {
        return street + "," + city + "," + state + " " + zip;
    }
}