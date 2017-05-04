package com.personal.util;

import java.io.Serializable;
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Created by prajeev on 19/3/17.
 */
public class BinaryTree implements Serializable {
    public TreeNode root;

    public void printPreOrder() {
        printPreOrderInternal(this.root);
    }

    private void printPreOrderInternal(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.number==null?root.data:root.number);
        printPreOrderInternal(root.left);
        printPreOrderInternal(root.right);
    }

    public void printinOrder() {
        printinOrderInternal(this.root);
    }

    private void printinOrderInternal(TreeNode root){
        if(root == null)
            return;
        printinOrderInternal(root.left);
        System.out.print(root.number==null?root.data:root.number);
        printinOrderInternal(root.right);
    }



    public void printPostOrder() {
        printPostOrderInternal(root);
    }

    private void printPostOrderInternal(TreeNode root){
        if(root == null)
            return;
        printPostOrderInternal(root.left);
        printPostOrderInternal(root.right);
        System.out.print(root.number==null?root.data:root.number);
    }

    public void printLevelOrder(){
        Queue<TreeNode> printQueue = new java.util.LinkedList<>();
        printQueue.add(this.root);
        printLevelOrderInternal(printQueue);
    }

    private void printLevelOrderInternal(Queue<TreeNode> printQueue) {
        if(printQueue.isEmpty()){
            return;
        }
        TreeNode examination = printQueue.remove();
        System.out.println(examination.number);
        if(examination.left!=null)
            printQueue.add(examination.left);
        if(examination.right!=null)
            printQueue.add(examination.right);
        printLevelOrderInternal(printQueue);

    }

    public BinaryTree(int root) {
        TreeNode treeNode = new TreeNode(root);
        this.root = treeNode;
        this.root.left = null;
        this.root.right = null;
    }

    public BinaryTree() {
        super();
    }

    public int height(){
        return computeHeight(root);
    }

    public int computeHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int lHeight = computeHeight(node.left);
        int rHeight = computeHeight(node.right);
        if (lHeight > rHeight){
            return 1+lHeight;
        } else {
            return 1+rHeight;
        }
    }

    public int size(){
        return computeSize(this.root);
    }

    private int computeSize(TreeNode node) {
        if(node==null){
            return 0;
        }
        return 1+ computeSize(node.left)+ computeSize(node.right);

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BinaryTree){
            BinaryTree that = (BinaryTree) obj;
            if(btreeEquals(this.root,that.root)){
                return true;
            }
        }
        return  false;
    }

    private boolean btreeEquals(TreeNode lhs, TreeNode rhs) {
        if(lhs == null || rhs == null){
            return true;
        }
        return (lhs.number.equals(rhs.number)) && btreeEquals(lhs.left,rhs.left) && btreeEquals(lhs.right,rhs.right);
    }

    public void mirror(){
        realMirror(this.root);
    }

    private void realMirror(TreeNode node) {
        if(node==null){
            return;
        }
        realMirror(node.left);
        realMirror(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public void printAllPaths(){
        Stack<TreeNode> treeStack = new Stack<>();
        printAllPaths(this.root,treeStack);
    }


    private void printAllPaths(TreeNode node, Stack<TreeNode> treeStack) {
        if(node==null){
            return;
        }
        treeStack.push(node);
        if(node.left == null && node.right == null){
            System.out.println(treeStack);
        }else {
            if(node.left!=null) {
                printAllPaths(node.left, treeStack);
                treeStack.pop();
            }
            if(node.right!=null) {
                printAllPaths(node.right, treeStack);
                treeStack.pop();
            }
        }
    }

    public int countLeaves(){
        return countLeavesInternal(this.root);
    }

    private int countLeavesInternal(TreeNode node) {
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right==null){
            return 1;
        }
        return countLeavesInternal(node.left)+countLeavesInternal(node.right);
    }

    public void printSpiralOrder(){
        Stack<TreeNode> printStack = new Stack<>();
        printStack.add(root);
        printSpiralOrderInternal(printStack,false);
    }

    private void printSpiralOrderInternal(Stack<TreeNode> printStack,boolean flip) {
        if(printStack.isEmpty()){
            return;
        }
        Stack tempStack = new Stack();
        while (!printStack.empty()){
            TreeNode examination = printStack.pop();
            System.out.println(examination.number);
            if(!flip) {
                if (examination.left != null)
                    tempStack.push(examination.left);
                if (examination.right != null)
                    tempStack.push(examination.right);
            } else {
                if (examination.right != null)
                    tempStack.push(examination.right);
                if (examination.left != null) {
                    tempStack.push(examination.left);
                }
            }
        }

        printSpiralOrderInternal(tempStack,!flip);
    }

    public boolean isTreeBST(){
        return isTreeBSTInteral(root);
    }

    private boolean isTreeBSTInteral(TreeNode node) {
        if(node == null || (node.left==null && node.right==null)){
            //its balanced till this point.
            return true;
        }

        if(node.right==null || !(node.left.number.compareTo(node.number) <= 0)){
            return false;
        }
        if(node.left==null || !(node.right.number.compareTo(node.number)==1)){
            return false;
        }
        if(!(node.left.number.compareTo(node.number) <= 0 &&  node.right.number.compareTo(node.number)==1)){
            return false;
        }
        return isTreeBSTInteral(node.left) && isTreeBSTInteral(node.right);
    }

    /**
     * amazon interview question: in a binary tree replace all the nodes with the sum of its children:
     * algorithm:
     * -if you have reached the bottom of the tree add copy the left leaf or right leaf if the other one
     * is empty.
     * otherwise replace this with the sum of both of its children
     *
     */
    public void summer(){
        summerInternal(root);
    }


    private void summerInternal(TreeNode node) {
        if(node.left == null && node.right==null){
            return;
        }
        if(node.left == null & node.right!=null){
            node.number.number = node.right.number.number;
            return;
        }
        if(node.left != null & node.right==null){
            node.number.number = node.left.number.number;
            return;
        } else {
            node.number.number = node.left.number.number + node.right.number.number;
        }
        if(node.left!=null)
            summerInternal(node.left);
        if(node.right!=null)
            summerInternal(node.right);
        return;

    }

    public void printLeftView(){
        ComparableNumber maxlevel = new ComparableNumber(0);
        printLeftViewInternal(root,1,maxlevel);
    }


    public void printRightView(){
        ComparableNumber maxlevel = new ComparableNumber(0);
        printRightViewInternal(root, 1, maxlevel);
    }

    private void printRightViewInternal(TreeNode node, int level, ComparableNumber maxlevel) {
        if(node == null){
            return;
        }

        if(level > maxlevel.number){
            System.out.printf(" %s ", node.number);
            maxlevel.number = level;
        }
        printRightViewInternal(node.right, level+1,maxlevel);
        printRightViewInternal(node.left, level+1,maxlevel);
    }


    private void printLeftViewInternal(TreeNode node, int level, ComparableNumber maxlevel) {
        if(node==null){
            return;
        }
        if(level > maxlevel.number) {
            System.out.printf(" %s ",node.number);
            maxlevel.number = level;
        }
        printLeftViewInternal(node.left,level+1, maxlevel);
        printLeftViewInternal(node.right,level+1, maxlevel);

    }

    public void printTreeWithLongitude(){
        printTreeWithLongitudeInternal(root, 0);
    }

    public void printTreeVertically(){
        Map<Integer,List<ComparableNumber>> orderedLongitudeMap = new TreeMap<>();
        prePareLongitudanalMap(orderedLongitudeMap,this.root,0);
        orderedLongitudeMap
                .keySet()
                .stream()
                .forEach((key) -> {
                    orderedLongitudeMap.get(key).stream().forEach((comparableNumber) -> {
                        System.out.printf(" %s ", comparableNumber);
                    });
                });
    }

    private void prePareLongitudanalMap(Map<Integer, List<ComparableNumber>> orderedLongitudeMap,
                                        TreeNode node, int grid) {
        if(node == null) {
            return;
        }
        if(orderedLongitudeMap.containsKey(grid)){
            orderedLongitudeMap.get(grid).add(node.number);
        } else {
            List<ComparableNumber> comparableNumbers = new LinkedList<>();
            comparableNumbers.add(node.number);
            orderedLongitudeMap.put(grid, comparableNumbers);
        }
        prePareLongitudanalMap(orderedLongitudeMap, node.left, grid - 1);
        prePareLongitudanalMap(orderedLongitudeMap, node.right, grid + 1);

    }

    private void printTreeWithLongitudeInternal(TreeNode node, int grid) {
        if(node == null){
            return;
        }
        System.out.printf("%d ------> %s\n", grid, node.number);
        printTreeWithLongitudeInternal(node.left, grid - 1);
        printTreeWithLongitudeInternal(node.right, grid + 1);
    }

    public void printTopView() {
        Map<Integer,ComparableNumber> orderedLongitudeMap = new TreeMap<>();
        prePareLongitudanalTopMap(orderedLongitudeMap, this.root, 0);
        orderedLongitudeMap.keySet().stream().forEach((key) -> {
            System.out.printf(" %s ", orderedLongitudeMap.get(key));});

    }

    private void prePareLongitudanalTopMap(Map<Integer, ComparableNumber> orderedLongitudeMap, TreeNode node, int grid) {
        if(node == null){
            return;
        }
        if(!orderedLongitudeMap.containsKey(grid)){
            orderedLongitudeMap.put(grid,node.number);
        }
        prePareLongitudanalTopMap(orderedLongitudeMap,node.left,grid-1);
        prePareLongitudanalTopMap(orderedLongitudeMap,node.right,grid+1);
    }

    public void printBottomView() {
        Map<Integer,ComparableNumber> orderedLongitudeMap = new TreeMap<>();
        prePareLongitudanalBottomMap(orderedLongitudeMap, this.root, 0);
        orderedLongitudeMap.keySet().stream().forEach((key) -> {
            System.out.printf(" %s ", orderedLongitudeMap.get(key));});
    }

    private void prePareLongitudanalBottomMap(Map<Integer, ComparableNumber> orderedLongitudeMap, TreeNode node, int grid) {
        if(node == null){
            return;
        }
        orderedLongitudeMap.put(grid,node.number);
        prePareLongitudanalBottomMap(orderedLongitudeMap,node.left,grid-1);
        prePareLongitudanalBottomMap(orderedLongitudeMap,node.right,grid+1);
    }

    public boolean checkRootToLeafSum(int sum){
        Stack<TreeNode> printstack = new Stack<>();
        return checkRootToLeafSumInternal(root,printstack,sum);
    }

    private boolean checkRootToLeafSumInternal(TreeNode node, Stack<TreeNode> printstack, int sum) {
        if(node==null) {
            return false;
        }
        printstack.push(node);
        if (node.left == null && node.right == null) {
            int currentSum = printstack.
                    stream().
                    reduce((t1, t2) -> {
                        return new TreeNode(((t1 == null) ? 0 : t1.number.number) + ((t2 == null) ? 0 : t2.number.number));
                    })
                    .get().number.number;
            System.out.println(currentSum);
            if(sum==currentSum){
                return true;
            }
        } else {
            if (node.left != null) {
                boolean check = checkRootToLeafSumInternal(node.left, printstack, sum);
                if(check){return true;}
                printstack.pop();
            }
            if (node.right != null) {
                boolean check = checkRootToLeafSumInternal(node.right, printstack, sum);
                if(check){return true;}
                printstack.pop();
            }
        }
        return false;
    }

    public int getDistance(TreeNode thiz, TreeNode dat){
        LockedStack<TreeNode> leftStack = new LockedStack<>();
        leftStack.push(root);
        LockedStack<TreeNode> rightStack = new LockedStack<>();
        rightStack.push(root);
        getStackToNode(thiz, leftStack);
        getStackToNode(dat,rightStack);
        List<TreeNode> leftList = leftStack.stream().collect(Collectors.toList());
        List<TreeNode> rightList = rightStack.stream().collect(Collectors.toList());
        System.out.println(leftList);
        System.out.println(rightList);
        return parseDistance(leftList,rightList);
    }

    private int parseDistance(List<TreeNode> leftList, List<TreeNode> rightList) {
        for(int i = leftList.size()-1 ; i >=0 ; i--){
            if(rightList.contains(leftList.get(i))){
                //found the common element;
                return leftList.size()-1-i + rightList.size()-1-rightList.indexOf(leftList.get(i));
            }
        }
        return 0;
    }

    private void popToSameStartPoint(LockedStack<TreeNode> thisStack, LockedStack<TreeNode> thatStack) {
        while(thisStack.get(0)!=thatStack.get(0)){
            thisStack.remove(0);
        }
    }

    private void getStackToNode(TreeNode target, LockedStack<TreeNode> stack) {
        if(stack.isEmpty()){
            return;
        }
        TreeNode examination = stack.peek();
        if(target == examination){
            stack.setLocked(true);
            return;
        }
        if(examination!=null){
           if(examination.left!=null){
               stack.push(examination.left);
               getStackToNode(target,stack);
               stack.pop();
           }
            if(examination.right!=null){
                stack.push(examination.right);
                getStackToNode(target,stack);
                stack.pop();
            }
        }
    }

    /**
     * given a node it gives its depth.
     * @param node
     */
    public int getNodeDepth(TreeNode node){
        return getNodeDepthInternal(root, node, 1);
    }

    private int getNodeDepthInternal(TreeNode node, TreeNode target, int level) {
        if(node == target){
            return level;
        } else {
            if(node.left != null){
                return getNodeDepthInternal(node.left,target,level+1);
            }
            if(node.right != null){
                return getNodeDepthInternal(node.right,target,level+1);
            }
        }
        return level;
    }

    public TreeNode getLowestCommonAncestor(TreeNode thiz, TreeNode dat){
        LockedStack<TreeNode> leftStack = new LockedStack<>();
        leftStack.push(root);
        LockedStack<TreeNode> rightStack = new LockedStack<>();
        rightStack.push(root);
        getStackToNode(thiz, leftStack);
        getStackToNode(dat,rightStack);
        List<TreeNode> leftList = leftStack.stream().collect(Collectors.toList());
        List<TreeNode> rightList = rightStack.stream().collect(Collectors.toList());
        System.out.println();
        System.out.println(leftList);
        System.out.println(rightList);
        return findLCAFromStacks(leftList, rightList);
    }

    private TreeNode findLCAFromStacks(List<TreeNode> leftList, List<TreeNode> rightList) {
        for(int i = leftList.size()-1 ; i >=0 ; i--){
            if(rightList.contains(leftList.get(i))){
                //found the common element;
                return leftList.get(i);
            }
        }
        return null;
    }

    public int getDiameter() {
        return 1+ computeHeight(root.left)+computeHeight(root.right);

     }
}
