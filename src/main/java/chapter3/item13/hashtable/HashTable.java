package chapter3.item13.hashtable;

public class HashTable implements Cloneable {
    private Entry[] buckets;

    private static class Entry {
        final Object key;
        StringBuilder value;
        Entry next;

        Entry(Object key, StringBuilder value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy() {
            return new Entry(key, new StringBuilder(value.toString()), next == null ? null : next.deepCopy());
        }
    }

    public HashTable(int size) {
        buckets = new Entry[size];
    }

    public void put(Object key, StringBuilder value) {
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

    public StringBuilder get(Object key) {
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

    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = deepCopyLinkedList(buckets[i]);
                }
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private Entry deepCopyLinkedList(Entry entry) {
        if (entry == null) {
            return null;
        }
        Entry newEntry = new Entry(entry.key, new StringBuilder(entry.value.toString()), deepCopyLinkedList(entry.next));
        return newEntry;
    }

    private int getIndex(Object key) {
        return key.hashCode() % buckets.length;
    }

    public static void main(String[] args) {
        HashTable original = new HashTable(10);
        original.put("key1", new StringBuilder("value1"));

        /* Clone the original HashTable instance. */
        HashTable clone = original.clone();

        /* Modify the value in the cloned object. */
        clone.get("key1").append("Updated");

        /* Access the value from the original object. */
        StringBuilder originalValue = original.get("key1");

        /* Access the value from the cloned object. */
        StringBuilder clonedValue = clone.get("key1");

        System.out.println("Original value -> " + originalValue);
        System.out.println("Cloned value -> " + clonedValue); // Should be "value1Updated"
    }
}
