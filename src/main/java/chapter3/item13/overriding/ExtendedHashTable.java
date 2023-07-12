package chapter3.item13.overriding;

import chapter3.item13.hashtable.HashTable;

public class ExtendedHashTable<K, V> extends HashTable<K, V> {
    private HashTable.Entry[] buckets;

    @Override
    public void put(K key, V value) {
        super.put(key, value);
        // Increase size by an additional 1 for each entry causing inconsistent state.
    }

    @Override
    public ExtendedHashTable<K, V> clone() {
        @SuppressWarnings("unchecked")
        ExtendedHashTable<K, V> result = (ExtendedHashTable<K, V>) super.clone();
        result.buckets = new Entry[buckets.length];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                for (Entry<K,V> e = buckets[i]; e != null; e = e.testNext) {
                    result.put(((Entry<K, V>) e).testKey, e.testValue);
                }
            }
        }
        return result;
    }

}
