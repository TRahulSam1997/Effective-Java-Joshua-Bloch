package Item7.callbacks;

import java.util.WeakHashMap;

/** Example courtesy of Ingo Kegel */

/**
 * Since Java doesn't support function pointers this represents a callback.
 * Effectively, It's a reference to the function which will be called.
 */
interface Listener {
    void event();
}

/** CallBacksDemo represents the mock API user. */
public class CallBacksDemo {
    Listener listener = null;
    public void registerListener() {

        /** The client of the API maintains a strong reference. */
        listener = new Listener() {
            @Override
            public void event() {
                System.out.println("Some task... ");
            }
        };

        /** The observer registers itself. */
        Api.registerListener(listener);
    }

    /** This class represents the subject in the Observer Pattern. */
}

class Api {

    /**
     * The API maintains a weak reference.
     * When the client is garbage collected, the listener is also garbage collected.
     */
    static WeakHashMap<Listener, Object> listeners = new WeakHashMap<>();
    static void registerListener(Listener listener) {
        listeners.put(listener, null);
    }

    static void fireListeners() {
        for (Listener listener : listeners.keySet()) {
            /** Checks if the listener is registered. */
            if (listener != null) {
                listener.event();
            }
        }
    }
}
