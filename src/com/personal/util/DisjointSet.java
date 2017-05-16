package com.personal.util;

/**
 * Created by pr250155 on 5/16/17.
 */
public class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++) {
            parent[i] = i;
        }
    }

    public int find(int item) {
        if(parent[item] == item) {
            //if item is the representative of its own set
            return item;
        } else {
            return find(parent[item]);
        }
    }

    public void union(int a , int b) {
        int repA = find(a);
        int repB = find(b);

        if(repA == repB) return;

        if(rank[repA] > rank[repB]){
            parent[repB] = parent[repA];
        } else if(rank[repB] > rank[repA]) {
            parent[repA] = parent[repB];
        } else {
            parent[repA] = parent[repB];
            rank[repA] += 1;
        }
    }
}
