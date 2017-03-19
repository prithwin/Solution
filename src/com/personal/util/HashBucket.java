package com.personal.util;

import java.util.Set;

/**
 * Created by prajeev on 19/3/17.
 */
public class HashBucket<E> {
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
}
