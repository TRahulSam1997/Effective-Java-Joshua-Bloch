package chapter4.item15;

public class SuperSecretPerson {
    // Private fields hide internal data from other classes
    private String firstName = "Kurt";
    private String lastName = "Gödel";

    // Public method provides controlled access to the name
    public String getName() {
        return firstName + " " + lastName;
    }

    public void updateName(String newFirstName, String newLastName) {
        if (newFirstName != null && newLastName != null) {
            this.firstName = newFirstName;
            this.lastName = newLastName;
        }
    }

    public static void main(String[] args) {
        SuperSecretPerson person = new SuperSecretPerson();

        // Accessing name through the API method
        System.out.println("Person's name: " + person.getName());

        // Updating name using the encapsulated API
        person.updateName("Albert", "Einstein");
        System.out.println("Updated person's name: " + person.getName());
    }
}
