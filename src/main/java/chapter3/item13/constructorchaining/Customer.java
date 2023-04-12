package chapter3.item13.constructorchaining;

import java.util.Objects;

public class Customer extends Person {
    private final String loyaltyCardId;

    public Customer(String firstName, String lastName, int age, String loyaltyCardId) {
        this(firstName, null, lastName, age, loyaltyCardId);
    }

    /** Constructor chaining. */
    public Customer(String firstName, String middleName, String lastName, int age, String loyaltyCardId) {
        super(firstName, middleName, lastName, age);
        this.loyaltyCardId = loyaltyCardId;
    }

    public String getLoyaltyCardId() {
        return loyaltyCardId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Customer customer = (Customer) obj;
        return Objects.equals(loyaltyCardId, customer.loyaltyCardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loyaltyCardId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + getFirstName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", loyaltyCardId='" + loyaltyCardId + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Customer customer = new Customer("John", "Doe", "Smith", 30, "12345");
        System.out.printf("customer -> " + customer);
    }
}

