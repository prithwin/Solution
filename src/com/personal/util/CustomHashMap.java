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
            if(temp.getKey().equals(mapNode.getKey())){
                temp.setValue(mapNode.getValue());return;
            }
            while (temp.next != null) {
                if(temp.getKey().equals(mapNode.getKey())){
                    temp.setValue(mapNode.getValue());return;
                }
                temp = temp.next;
            }
            temp.next = mapNode;
        }
    }

    private void ensureBucketCapacity(int bucket) {
        if(bucket<=buckets.length-1) return;
        MapNode[] bucketstemp = new MapNode[bucket+1];
        for(int i = 0 ; i < buckets.length ; i++) {
            bucketstemp[i] = buckets[i];
        }
        buckets = bucketstemp;
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
        if(bucket >= buckets.length - 1) return false;
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

    public MapNode[] getBuckets(){
        return buckets;
    }

}


