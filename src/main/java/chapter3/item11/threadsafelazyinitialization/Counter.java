package chapter3.item11.threadsafelazyinitialization;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread-safe counter class.
 * Operations in this class are Atomic as we're using AtomicInteger methods.
 */
public class Counter {
    private AtomicInteger count;
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
        if (hashCode.get() == 0) {
            hashCode.set(31 * hashCode.get() + count.get());
        }
        return hashCode.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(10);

        /** Two threads trying to change the count at the same time. */
        Thread t1 = new Thread(() -> counter.setCount(15));
        Thread t2 = new Thread(() -> counter.setCount(20));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount());
        System.out.println("Final hashCode: " + counter.hashCode());
    }
}