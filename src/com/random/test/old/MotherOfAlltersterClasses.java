package com.random.test.old;

import com.personal.util.AVLTreeNode;
import com.personal.util.TreeNode;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.*;

/**
 * Created by prajeev on 16/3/17.
 */
public class MotherOfAlltersterClasses {
    public static void main(String[] args) {

//        Map<Number,String> testMap = new HashMap<Number,String>();
        Map<Number,String> testMap = new TreeMap<Number,String>();
//        Map<Number,String> testMap = new LinkedHashMap<Number,String>();

        testMap.put(new Number(1),"A");
        testMap.put(new Number(4),"A");
        testMap.put(new Number(5),"A");
        testMap.put(new Number(2),"A");
        testMap.put(new Number(3),"A");
        for(Number key : testMap.keySet()){
            System.out.println(key.number);
        }
        A a = new A();
        try {
            a.doSomething(null);
        } catch (Exception e){

        }
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        for(Integer thing : integerList) {
            integerList.remove(thing);
        }
    }

    static class Number implements Comparable {
        int number;

        Number(int i){
            this.number = i;
        }

        @Override
        public boolean equals(Object obj) {
            Number rhs = (Number)obj;
            return number==rhs.number;
        }


        @Override
        public int compareTo(Object o) {
            Number rhs = (Number)o;
            if (this.number == rhs.number)
                return 0;
            return
                    (this.number-rhs.number)/((this.number-rhs.number)>0 ?
                    (this.number-rhs.number)
                    :
                    -1*(this.number-rhs.number));
        }
    }
}

class A{
    public TreeNode doSomething(TreeNode node) throws Exception {
        System.out.println("doing Something");
        return null;
    }
}

class  C extends A {
    @Override
    public AVLTreeNode doSomething(TreeNode node) throws IOException{
        //super.doSomething(node);
        return null;
    }
}


interface Binterface {
    List<?> Bmethod() throws IOException;
}

class Bclass implements Binterface {

    @Override
    public List<?> Bmethod() throws AccessDeniedException {
        return null;
    }
}
