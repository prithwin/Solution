package com.personal.util;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by prajeev on 19/3/17.
 * constant amortized constant time HashMap
 */
public class CustomHashMap<K,V> {

    MapNode[] buckets = new MapNode[100];

    public void put(K key, V value) {
        MapNode<K, V> mapNode = new MapNode();
        mapNode.setKey(key);
        mapNode.setValue(value);
        int bucket = key.hashCode();
        ensureBucketCapacity(bucket);
        if (buckets[bucket] == null) {
            buckets[bucket] = mapNode;
        } else {
            MapNode temp = buckets[bucket];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = mapNode;
        }
    }

    private void ensureBucketCapacity(int bucket) {
        buckets = Arrays.copyOf(buckets,bucket+1);
    }

    public V get(K key){
        int bucket = key.hashCode();
        if(buckets[bucket] != null){
            MapNode temp = buckets[bucket];
            while(temp!=null){
                if(temp.getKey().equals(key)){
                    return (V) temp.getValue();
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key){
        int bucket = key.hashCode();
        if(buckets[bucket] != null){
            MapNode temp = buckets[bucket];
            while(temp!=null){
                if(temp.getKey().equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

}


