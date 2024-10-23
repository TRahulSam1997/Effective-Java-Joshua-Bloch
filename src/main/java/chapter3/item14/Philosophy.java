package chapter3.item14;

public class Philosophy {
    // Choosing composition over inheritance
    private final Philosopher philosopher;
    private final String philosophy;

    public Philosophy(Philosopher philosopher, String philosophy) {
        this.philosopher = philosopher;
        this.philosophy = philosophy;
    }

    // The "view" method exposes the underlying Philosopher
    public Philosopher getPhilosopher() {
        return philosopher;
    }

    public int compareTo(Philosophy otherObject) {
        int signumResult = philosopher.compareTo(otherObject.philosopher);
        // If != 0, no equality in the composing class
        if (signumResult != 0) return signumResult;

        return philosophy.compareTo(otherObject.philosophy);
    }

    @Override
    public String toString() {
        return philosopher.name() + " (" + philosopher.age() + "), Style: " + philosopher;
    }
}

class Demo {
    public static void main(String[] args) {

        // Create basic Philosopher objects
        Philosopher Kant = new Philosopher("Kant", 79);
        Philosopher Hegel = new Philosopher("Hegel", 61);
        Philosopher Wittgenstein = new Philosopher("Wittgenstein", 62);

        // Create Philosophy objects using composition
        Philosophy KantianPhilosophy = new Philosophy(Kant, "Transcendental Idealism");
        Philosophy HegelianPhilosophy = new Philosophy(Hegel, "Absolute Idealism");
        Philosophy WittgensteinianPhilosophy = new Philosophy(Wittgenstein, "Analytic Philosophy");

        // Comparing contained Philosopher objects
        System.out.println("Comparing Kant and Wittgenstein -> " + Kant.compareTo(Wittgenstein));  // Comparing ages

        // Comparing Philosophy objects
        System.out.println("Comparing Kantian and Hegelian Philosophy -> " + KantianPhilosophy.compareTo(HegelianPhilosophy)); // Compare age and style
        System.out.println("Comparing Kantian and Wittgensteinian Philosophy -> " + KantianPhilosophy.compareTo(WittgensteinianPhilosophy));

        // Accessing the contained Philosopher
        System.out.println("Kant the philosopher: " + KantianPhilosophy.getPhilosopher()); // Shows Kant's base details
    }
}
