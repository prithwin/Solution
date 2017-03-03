package com.personal;

/**
 * Created by prajeev on 5/7/16.
 */
public class Permutations {

    public static void generate(String remainderString,String set){


        if(remainderString.length()==1){
            System.out.print(set);
            System.out.print(remainderString);
            System.out.print("\n");
            return;
        }

        char[] charArray = remainderString.toCharArray();

        for(int i = 0 ; i <charArray.length ; i++){
            String reminderWithoutlead = getRemainderString(i,charArray);
            generate(reminderWithoutlead,set+charArray[i]);
        }
    }

    public static void main(String[] args){
        generate("ABCD","");
    }

    private static String getRemainderString(int i, char[] charArray) {
        StringBuilder output = new StringBuilder();
        for(int j = 0 ; j< i ;j++){
            output.append(charArray[j]);
        }
        //add all the ones after i
        for(int j = i+1 ; j< charArray.length ;j++){
            output.append(charArray[j]);
        }

        return output.toString();
    }
}
