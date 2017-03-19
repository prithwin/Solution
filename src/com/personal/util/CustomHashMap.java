package com.personal.util;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by prajeev on 19/3/17.
 */
public class CustomHashMap<K,V> {
    private List<HashBucket> buckets;

    public void put(K key, V value){
        if(buckets == null){
            buckets = new LinkedList<HashBucket>();
        }

        if(!containsHashvalue(buckets,key.hashCode())){
            HashBucket hashBucket = new HashBucket();
            hashBucket.setItems(new HashSet<MapNode<K,V>>());
            hashBucket.setBucketHashCode(key.hashCode());
            buckets.add(hashBucket);
        }
        for (HashBucket bucket : buckets){
            if(bucket.getBucketHashCode() == key.hashCode()){
                MapNode<K,V> mapnode = new MapNode<K, V>();
                mapnode.setKey(key);
                mapnode.setValue(value);
                bucket.getItems().add(mapnode);
            }
        }
    }

    private boolean containsHashvalue(List<HashBucket> buckets,int hashCode) {
        for(HashBucket bucket : buckets){
            if(hashCode == bucket.getBucketHashCode()){
                return true;
            }
        }
        return false;
    }

    public V get(K key){
        for(HashBucket bucket : buckets){
            if(bucket.getBucketHashCode() == key.hashCode()){
                Set<MapNode> items = bucket.getItems();
                for(MapNode<K,V> mapNode : items){
                    if(mapNode.getKey().equals(key)){
                        return mapNode.getValue();
                    }
                }
            }
        }
        return null;
    }

}


