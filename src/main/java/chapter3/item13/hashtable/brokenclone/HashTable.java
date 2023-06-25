package chapter3.item13.hashtable.brokenclone;

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

    /** Broken clone method - results in shared mutable state! */
    @Override public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            /* Elements in the buckets array are not copied. */
            result.buckets = buckets.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private int getIndex(Object key) {
        return key.hashCode() % buckets.length;
    }

    public static void main(String[] args) {
        HashTable original = new HashTable(10);
        original.put("key1", "value1");

        /* Clone the original HashTable instance. */
        HashTable clone = original.clone();

        /* Modify the value in the cloned object. */
        clone.put("key1", "updatedValue");

        /* Access the value from the original object. */
        String originalValue = (String) original.get("key1");

        /* Access the value from the cloned object. */
        String clonedValue = (String) clone.get("key1");

        System.out.println("Original value -> " + originalValue);
        System.out.println("Cloned value -> " + clonedValue); // Should be "updatedValue"
    }
}
