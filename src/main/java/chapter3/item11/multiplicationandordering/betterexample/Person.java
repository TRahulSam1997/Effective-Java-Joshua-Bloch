package chapter3.item11.multiplicationandordering.betterexample;

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /** Good hashCode() implementation. */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (firstName == null ? 0 : firstName.hashCode());
        result = 31 * result + (lastName == null ? 0 : lastName.hashCode());
        return result;
    }

    /** Bad hashCode() implementation. */
//    @Override
//    public int hashCode() {
//        int result = 1;
//        result = (firstName == null ? 0 : firstName.hashCode());
//        result = result + (lastName == null ? 0 : lastName.hashCode());
//        return result;
//    }

    public static void main(String[] args) {
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Doe", "John");

        System.out.println("Person 1 -> " + person1.hashCode());
        System.out.println("Person 2 -> " + person2.hashCode());
    }
}