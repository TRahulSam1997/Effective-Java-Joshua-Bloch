package Item7.callbacks;

import java.util.WeakHashMap;

/** Example courtesy of Ingo Kegel */
public class CallBacksDemo {
    Listener listener;
    void registerListener() {
        listener = new Listener() {
            @Override
            public void event() {
                // TODO
            }
        };
        Api.registerListener(listener);
    }

    class Api {
        static WeakHashMap<Listener, Object> listeners = new WeakHashMap<>();
        static void registerListener(Listener listener) {
            listeners.put(listener, null);
        }

        static void fireListeners() {
            for (Listener listener : listeners.keySet()) {
                if (listener != null) {
                    listener.event();
                }
            }
        }
    }

    interface Listener {
        void event();
    }
}
