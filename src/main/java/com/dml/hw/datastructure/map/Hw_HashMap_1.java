package com.dml.hw.datastructure.map;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 第一遍， 抄一次 HashMap
 *
 * @author Louis
 * @version 1.0
 * @since 2019/11/11
 */
public class Hw_HashMap_1<K, V> extends AbstractMap<K,V>
        implements Map<K,V>{

    private HashMap<String, String> hashMap = new HashMap<>();



    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16


    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;


    /**
     * The load factor for the hash table.
     *
     * @serial
     */
    final float loadFactor;


    transient Hw_HashMap_1.Node<K,V>[] table;


    public Hw_HashMap_1() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }


    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    //TODO
    private V putVal(int hash, K key, V value, boolean b, boolean b1) {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash
     * to lower.  Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
     */
    static final int hash(Object key) {
        int h;

        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        int h1;
        int h2;
        int hash2;

        if (key == null) {
            return 0;
        } else {

            h1 = key.hashCode();
            h2 = h1 >>> 16;
        }

        hash2 = h1 ^ h2;

        System.out.println("hash == hash2 : " + String.valueOf(hash == hash2));

        return hash2;
    }



    static class Node<K,V> implements Map.Entry<K,V> {

        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }


}
