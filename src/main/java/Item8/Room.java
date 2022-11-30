package Item8;
import java.lang.ref.Cleaner;

/**
 * Code taken from - https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter2/item8/Room.java
 * An autocloseable class using a cleaner as a safety net (Page 32)
 * Room must be cleaned before being reclaimed.
 */
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    /** Resource that requires cleaning. Must not refer to Room!
     * The inner class holds resources required by cleaner to clean Room.
     */
    private static class State implements Runnable {
        /** Number of junk piles is the only resource, in this case. */
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        /** Invoked by close method or cleaner.
         * If the client fails close the Room instance cleaner will
         * (hopefully) call this run method.
         */
        @Override public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    /** The state of this room, shared with our cleanable. */
    private final State state;

    /** Our cleanable. Cleans the room when it’s eligible for gc. */
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    /** This will trigger a call to State.run() */
    @Override public void close() {
        cleanable.clean();
    }
}