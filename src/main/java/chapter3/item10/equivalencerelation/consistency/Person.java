package chapter3.item10.equivalencerelation.consistency;

/**
 * Example courtesy of ChatGPT.
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }

        /**
         * name and age are compared to test for equality,
         * which are not modified after object creation.
         */
        return ((Person) o).name.equals(name) && ((Person) o).age == age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        Person p3 = new Person("Bob", 30);

        /** Multiple invocations of p1.equals(p2) will consistently return true */
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p2));

        /** Multiple invocations of p1.equals(p3) will consistently return false */
        System.out.println(p1.equals(p3));
        System.out.println(p1.equals(p3));

    }
}