package chapter3.item13.hashtable;

public class HashTable implements Cloneable {
    private Entry[] buckets;
    private static class Entry {
        final Object key;
        Object value;
        Entry next;
        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /** Recursively copy the linked list headed by this Entry. */
        Entry deepCopy() {
            return new Entry(key, value,
                    next == null ? null : next.deepCopy());
        }

//        /** Iteratively copy the linked list headed by this Entry. */
//        Entry deepCopy() {
//            Entry result = new Entry(key, value, next);
//            for (Entry p = result; p.next != null; p = p.next)
//                p.next = new Entry(p.next.key, p.next.value, p.next.next);
//            return result;
//        }
    }

    public HashTable(int size) {
        buckets = new Entry[size];
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);
        Entry entry = buckets[index];
        if (entry == null) {
            buckets[index] = new Entry(key, value, null);
        } else {
            while (entry.next != null) {
                entry = entry.next;
            }
            entry.next = new Entry(key, value, null);
        }
    }

    public Object get(Object key) {
        int index = getIndex(key);
        Entry entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++)
                if (buckets[i] != null)
                    result.buckets[i] = buckets[i].deepCopy();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private int getIndex(Object key) {
        return key.hashCode() % buckets.length;
    }
}
