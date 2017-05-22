package com.personal.util;

/**
 * Created by prajeev on 19/3/17.
 */
public class MapNode<K,V> {

    private K key;
    private V value;
    MapNode<K,V> next;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object other) {
        MapNode<K,V> that = (MapNode<K,V>) other;
        if(this.key.equals(that.key)){
            return true;
        }
        return false;
    }
}
