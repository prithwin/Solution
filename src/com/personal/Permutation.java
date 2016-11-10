package com.personal;

/**
 * Created by prajeev on 20/7/16.
 */
public class Permutation {
    public void realPermute(int[] sourceArray,int[] dataStore,int startIndex,int endIndex, int dataStoreIndex, int combinationSize){
        if(dataStoreIndex == combinationSize){
            for(int token : dataStore){
                System.out.print(token);
            }
            System.out.print("\n");
            return;
        }

        for(int i = startIndex ; i <= endIndex && endIndex-i+1 >= combinationSize-dataStoreIndex ;i++){

            if(!contains(dataStore,sourceArray[i])){
                dataStore[dataStoreIndex] = sourceArray[i];
            } else {
                continue;
            }

            //datastore already has the current element continue;
            realPermute(sourceArray,dataStore,0,endIndex,dataStoreIndex+1,combinationSize);
        }


    }

    private boolean contains(int[] dataStore, int i) {
        for(int number : dataStore){
            if(number==i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int sourceArray[] = {1,2,3};
        int dataStore[] = new int[2];
        new Permutation().realPermute(sourceArray,dataStore,0,sourceArray.length-1,0,2);

    }

}
