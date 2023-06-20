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

    public HashTable clone() {
        try {
            HashTable clone = (HashTable) super.clone();
            clone.buckets = buckets.clone(); // Shallow copy of the array

            // Deep copy of the linked lists
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    clone.buckets[i] = cloneLinkedList(buckets[i]);
                }
            }

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    private Entry cloneLinkedList(Entry entry) {
        Entry newEntry = new Entry(entry.key, entry.value, null);
        Entry current = newEntry;
        while (entry.next != null) {
            entry = entry.next;
            current.next = new Entry(entry.key, entry.value, null);
            current = current.next;
        }
        return newEntry;
    }

    private int getIndex(Object key) {
        return key.hashCode() % buckets.length;
    }
}
