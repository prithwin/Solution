package com.personal;

import com.personal.util.Mathematical;
import com.personal.util.Print2DMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pr250155 on 4/14/17.
 */
public class KnapsackProblem {
    class Item {
        int value;
        int weight;

        Item(int value,  int weight){
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return value+","+weight;
        }
    }

    class KnapSackResult {
        int value;
        List<Item> valueables = new ArrayList<>();
    }
    List<Item> items = null;
    private static int KNAPSACK_CAPACITY=7;

    KnapsackProblem(){
        items = Arrays.asList(
                new Item(Integer.MAX_VALUE,Integer.MAX_VALUE),
                new Item(1,1),
                new Item(4,3),
                new Item(5,4),
                new Item(7,5));
    }

    public KnapSackResult getTotalValue(int weight){
        KNAPSACK_CAPACITY = weight;
        int[][] weightMatrix = new int[this.items.size()][KNAPSACK_CAPACITY+1];
        KnapSackResult result = new KnapSackResult();

        for(int itemIndex=0 ; itemIndex < items.size(); itemIndex++) {
            for(int kw = 0 ; kw < weightMatrix[itemIndex].length ; kw++){
                if(kw == 0 || itemIndex == 0){
                    weightMatrix[itemIndex][kw] = 0;
                } else if(kw < items.get(itemIndex).weight){
                    weightMatrix[itemIndex][kw] = weightMatrix[itemIndex-1][kw];
                }
                else{
                    weightMatrix[itemIndex][kw] = Mathematical.maximum(items.get(itemIndex).value +
                                    weightMatrix[itemIndex-1][kw-items.get(itemIndex).weight],
                            weightMatrix[itemIndex-1][kw]);
                }
            }
        }
        Print2DMatrix.print2dMatrix(weightMatrix);
        result.value = weightMatrix[this.items.size()-1][KNAPSACK_CAPACITY];
        //find the path
        for(int i = this.items.size()-1 ; i >=0 ;){
            for(int j = weightMatrix[i].length-1 ; j>=0 ; ){
                if(weightMatrix[i][j] == weightMatrix[i-1][j]){
                    i--;
                } else {
                    result.valueables.add(items.get(i));
                    j-=items.get(i).weight;
                }
            }
            //if(result.valueables.stream().collect()
        }
        return result;
    }

    public static void main(String[] args) {
        KnapSackResult result = new KnapsackProblem().getTotalValue(7);
        System.out.printf("the max value we can get is %d ",result.value);
        result.valueables.stream().forEach(System.out::print);
    }
}
