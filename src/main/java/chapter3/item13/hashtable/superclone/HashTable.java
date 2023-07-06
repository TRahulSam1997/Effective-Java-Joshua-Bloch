package chapter3.item13.hashtable.superclone;

public class HashTable<K, V> implements Cloneable {
    private static final int DEFAULT_CAPACITY = 10;
    private Entry[] buckets;
    private int size;

    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        buckets = new Entry[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        Entry<K, V> newEntry = new Entry<>(key, value, buckets[index]);
        buckets[index] = newEntry;
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    @Override
    public HashTable<K, V> clone() {
        try {
            @SuppressWarnings("unchecked")
            HashTable<K, V> clonedTable = (HashTable<K, V>) super.clone();
            clonedTable.buckets = new Entry[buckets.length];
            clonedTable.size = 0;
            /* Deep copy taking place without a field-by-field copy of the object. */
            for (Entry entry : buckets) {
                while (entry != null) {
                    clonedTable.put((K) entry.key, (V) entry.value);
                    entry = entry.next;
                }
            }
            return clonedTable;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

//    @Override
//    /* Shallow copy. */
//    public HashTable<K, V> clone() {
//        try {
//            @SuppressWarnings("unchecked")
//            HashTable<K, V> result = (HashTable<K, V>) super.clone();
//            result.buckets = buckets.clone();
//            return result;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }


    public static void main(String[] args) {
        HashTable<String, Integer> originalTable = new HashTable<>();
        originalTable.put("one", 1);
        originalTable.put("two", 2);
        originalTable.put("three", 3);

        /* Create a clone of the original HashTable. */
        HashTable<String, Integer> clonedTable = originalTable.clone();

        /* Modify the value in the cloned table. */
        clonedTable.put("one", 10);

        /* Access the values from the original and cloned tables. */
        Integer originalValue = originalTable.get("one");
        Integer clonedValue = clonedTable.get("one");

        System.out.println("Original value: " + originalValue);
        System.out.println("Cloned value: " + clonedValue);
    }
}

