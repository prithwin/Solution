package com.personal;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pr250155 on 5/25/17.
 */
public class ThreeSumEqualsK {

    public boolean isCombinationPossible(int[] target,int sum) {
        Set<Integer> registry = new HashSet<>() ;

        for(int i = 0 ; i < target.length ; i++){
            registry.add(target[i]);
        }
        for(int i = 0 ; i < target.length ; i++) {
            for(int j = 0 ; j < target.length ; j++){
                if( i == j) continue;
                int diff = sum - (target[i] + target[j]);
                if(diff == target[i] || diff == target[j]) continue;
                if(registry.contains(diff)){
                    System.out.printf("The combination is %d %d %d",target[i],
                            target[j],diff);
                    return true;
                }

            }
        }
        return false;
    }
}
