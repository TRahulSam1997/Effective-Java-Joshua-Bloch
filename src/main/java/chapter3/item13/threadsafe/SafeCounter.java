package chapter3.item13.threadsafe;

public class SafeCounter implements Cloneable {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

    // This clone method is not thread-safe!
    @Override
    public SafeCounter clone() {
        try {
            return (SafeCounter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }

    // Thread safe
//    @Override
//    public synchronized SafeCounter clone() {
//        try {
//            return (SafeCounter) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError(); // Can't happen
//        }
//    }
}

