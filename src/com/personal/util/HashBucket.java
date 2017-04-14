package com.personal.util;

import java.util.Set;

/**
 * Created by prajeev on 19/3/17.
 */
public class HashBucket<E> implements Comparable{
    private Set<MapNode> items;
    private int bucketHashCode;

    public int getBucketHashCode() {
        return bucketHashCode;
    }

    public void setBucketHashCode(int bucketHashCode) {
        this.bucketHashCode = bucketHashCode;
    }

    public Set<MapNode> getItems() {
        return items;
    }

    public void setItems(Set<MapNode> items) {
        this.items = items;
    }

    @Override
    public int compareTo(Object o) {
        HashBucket other = (HashBucket) o;
        if(this.bucketHashCode > other.bucketHashCode){
            return 1;
        } if(this.bucketHashCode < other.bucketHashCode){
            return -1;
        }
        return 0;
    }
}
