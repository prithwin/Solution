package com.personal;

import com.personal.util.Mathematical;
import com.personal.util.Print2DMatrix;

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

    //         0  1  2  3  4  5  6  7
    //  _INF   0  0  0  0  0  0  0  0
    //   1     0  1  1  1  1  1  1  1
    //   3     0
    //   4     0
    //   5     0
    public int getTotalValue(int weight){
        KNAPSACK_CAPACITY = weight;
        int[][] weightMatrix = new int[this.items.size()][KNAPSACK_CAPACITY+1];

        for(int itemIndex=0 ; itemIndex < items.size(); itemIndex++) {
            for(int kw = 0 ; kw < weightMatrix[itemIndex].length ; kw++){
                if(kw == 0 || itemIndex == 0){
                    weightMatrix[itemIndex][kw] = 0;
                } else if(kw < items.get(itemIndex).weight){
                    weightMatrix[itemIndex][kw] = weightMatrix[itemIndex-1][kw];
                }
                else{
                    System.out.printf("comparing %d with %d\n",items.get(itemIndex).value +
                            weightMatrix[itemIndex-1][kw-items.get(itemIndex).weight], items.get(itemIndex).value);
                    weightMatrix[itemIndex][kw] = Mathematical.maximum(items.get(itemIndex).value +
                                    weightMatrix[itemIndex-1][kw-items.get(itemIndex).weight],
                            items.get(itemIndex).value);
                }
            }
            System.out.println();
            Print2DMatrix.print2dMatrix(weightMatrix);
        }

        return 0;
    }

    public static void main(String[] args) {
        new KnapsackProblem().getTotalValue(7);
    }
}
