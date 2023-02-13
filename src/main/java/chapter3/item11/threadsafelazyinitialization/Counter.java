package chapter3.item11.threadsafelazyinitialization;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread-safe counter class.
 * Operations in this class are Atomic as we're using AtomicInteger methods.
 */
public class Counter {
    private AtomicInteger count;
    /** Holds a cached hash code value. */
    private AtomicInteger hashCode;

    public Counter(int count) {
        this.count = new AtomicInteger(count);
        this.hashCode = new AtomicInteger();
    }

    public int getCount() {
        return count.get();
    }

    public void setCount(int count) {
        this.count.set(count);
    }

    @Override
    public int hashCode() {
        /**
         * Checking if hashCode has a value of 0 ensures
         * the hash code is computed lazily.
         */
        if (hashCode.get() == 0) {
            hashCode.set(31 * hashCode.get() + count.get());
        }
        return hashCode.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(10);

        /** Two threads trying to change the count concurrently. */
        Thread t1 = new Thread(() -> counter.setCount(15));
        Thread t2 = new Thread(() -> counter.setCount(20));

        t1.start();
        t2.start();

        /**
         * Due to join() the final state of the Counter
         * will be used when getCount() is called because the main
         * thread waits for both child threads to finish execution.
         */
        t1.join();
        t2.join();

        /**
         * Since the AtomicInteger methods are used for the count and hashCode fields,
         * the count and hash code will be updated atomically.
         * And the final count will be either 15 or 20,
         * depending on which thread finishes last.
         * */
        System.out.println("Final count: " + counter.getCount());
        System.out.println("Final hashCode: " + counter.hashCode());
    }
}