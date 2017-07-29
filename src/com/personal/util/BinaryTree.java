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
        System.out.print(" "+(root.number==null?root.data:root.number)+" ");
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
        System.out.print(" "+(root.number==null?root.data:root.number)+" ");
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
        System.out.print(" "+(root.number==null?root.data:root.number)+" ");
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
        System.out.print(" "+examination.number+" ");
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

    public void add(TreeNode item, Integer key , boolean left) {
        addInternal(root,item,key,left);
    }

    private void addInternal(TreeNode node , TreeNode item , Integer key , boolean left) {
        if(node.entry.key == key) {
            if(left) {
                if(node.left != null) {
                    item.left = node.left;
                }
                node.left = item;
            } else {
                if(node.right != null) {
                    item.right = node.right;
                }
                node.right = item;
            }
            node.number = new ComparableNumber(item.entry.value);
            return;
        }
        if(node.left != null) {
            addInternal(node.left , item,key,left);
        }

        if(node.right != null) {
            addInternal(node.right , item,key,left);
        }
    }

    /**
    H(n){
        if n is NULL;
        return 0;
        lh , rh = 0;
        lh = 1 + H(n.left);
        rh = 1 + H(n.right);
        return max(lh,rh)
    }
     */
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

    /**
     *S(n) {
     * if n is null;
     *   return 0;
     * else
     *   return 1 + S(n.left) + S(n.right);
     */
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
            if(lhs == null && rhs != null){
                return false;
            } else if( lhs != null && rhs == null){
                return false;
            } else {
                return true;
            }
        }
        return (lhs.number.equals(rhs.number)) && btreeEquals(lhs.left,rhs.left) && btreeEquals(lhs.right,rhs.right);
    }

    /**
     * M(n) {
     *    if(n==null)return;
     *     M(n.left);
     *     M(n.right);
     *
     *     temp = n.left;
     *     n.left = n.right;
     *     n.right = temp;
     * }
     */
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

    /**
     * PrintPaths(n,S){
     *   S.push(n);
     *   if(n.left == null && n.right == null){
     *     print S;
     *   }
     *     if(n.left != null)
     *       PrintPaths(n.left,S); S.pop();
     *     if(n.right != null)
     *       PrintPaths(n.right,S); S.pop();
     *  }
     *
     */
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

    /**
     *  C(node) {
     *      if(node.left == null && node.right ==null){
     *          return 1;
     *      }
     *      int lc = 0
     *      if(node.left!=null){
     *          lc = C(node.left);
     *      }
     *      int rc = 0;
     *      if(node.right != null){
     *          rc = C(node.right);
     *      }
     *      return lc+rc;
     *  }
     * @return the nuumber of leaves
     */
    public int countLeaves(){
        return countLeavesInternal(this.root);
    }

    private int countLeavesInternal(TreeNode node) {
        if(node.left==null && node.right==null){
            return 1;
        }
        int leftCount = 0,rightCount = 0;
        if(node.left != null){
            leftCount = countLeavesInternal(node.left);
        }
        if(node.right!=null){
            rightCount = countLeavesInternal(node.right);
        }
        return leftCount + rightCount;
    }

    /**
     * SP(S,f) {
     *     if(S.isempty) return;
     *     DEFINE S';
     *     while(!S.isEmpty) {
     *         n = S.pop;
     *         PRINT n;
     *         if(f) {
     *             S'.push(n.left);
     *             S'.push(n.right);
     *         } else {
     *             S'.push(n.right);
     *             S'.push(n.left);
     *         }
     *     }
     *     SP(S',!f);
     * }
     */
    public void printSpiralOrder(){
        Stack<TreeNode> printStack = new Stack<>();
        printStack.push(this.root);
        printSpiralOrderInternal(printStack,false);
    }

    private void printSpiralOrderInternal(Stack<TreeNode> printStack ,boolean flip) {
        if(printStack.isEmpty()) return;

        Stack<TreeNode> levelStack = new Stack<>();
        while(!printStack.isEmpty()) {
            TreeNode node = printStack.pop();
            System.out.printf(" %s ",node.number);
            if(flip) {
                if(node.right != null)
                    levelStack.push(node.right);
                if(node.left != null)
                    levelStack.push(node.left);
            } else {
                if(node.left != null)
                    levelStack.push(node.left);
                if(node.right != null)
                levelStack.push(node.right);
            }
        }
        printSpiralOrderInternal(levelStack,!flip);
    }

    public boolean isTreeBST(){
        return isTreeBSTInternal(root);
    }

    private boolean isTreeBSTInternal(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }
        if (node.left == null && node.right.number.compareTo(node.number) == -1) {
            return false;
        }
        if (node.right == null && node.left.number.compareTo(node.number) == 1) {
            return false;
        }
        if (node.left != null && node.right != null) {
            if (node.left.number.compareTo(node.number) == 1) {
                return false;
            }
            if (node.right.number.compareTo(node.number) == -1) {
                return false;
            }
        }

        return isTreeBSTInternal(node.left) && isTreeBSTInternal(node.right);
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

    /**
     * plv(n,l,m){
     *     if n is Null
     *      return;
     *   if (l > m)
     *      print n;
     *      m = l;
     *   plv(n,l+1,m);
     * }
     */
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

    /**
     * PLM(n,M,g) {
     *     if(n == null) return;
     *      if(!M.containsKey(g)){
     *           M.put(g);
     *       }
     *       M.get(g).add(n);
     *   }
     *   PLM(n.left,M,g-1);
     *   PLN(n.right,M,g+1)
     *
     * }
     */
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
        Stack<TreeNode> printStack = new Stack<>();
        return checkRootToLeafSumInternal(root,printStack,sum);
    }

    private boolean checkRootToLeafSumInternal(TreeNode node, Stack<TreeNode> printStack, int sum) {
        if(node==null) {
            return false;
        }
        printStack.push(node);
        if (node.left == null && node.right == null) {
            int currentSum = printStack.
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
                boolean check = checkRootToLeafSumInternal(node.left, printStack, sum);
                if(check){return true;}
                printStack.pop();
            }
            if (node.right != null) {
                boolean check = checkRootToLeafSumInternal(node.right, printStack, sum);
                if(check){return true;}
                printStack.pop();
            }
        }
        return false;
    }

    /**
     * DISTANCE(this,that) {
     *     S = getStackToNode(this);
     *     S'= getStackToNode(that);
     *     L = toList(S);
     *     L' = toList(S');
     *     return parseDistance(L,L');
     * }
     * @param thiz a node
     * @param dat a another node
     * @return the distance between the nodes
     */
    public int getDistance(TreeNode thiz, TreeNode dat){
        Stack<TreeNode> leftStack = new Stack<>();
        leftStack.push(root);
        Stack<TreeNode> rightStack = new Stack<>();
        rightStack.push(root);
        List<TreeNode> leftList = getListToNode(thiz, leftStack);
        List<TreeNode> rightList = getListToNode(dat, rightStack);
        System.out.println(leftList);
        System.out.println(rightList);
        return parseDistance(leftList,rightList);
    }

    public List<TreeNode> getListToNode(TreeNode node,Stack<TreeNode> stack)  {
        if(stack.isEmpty()) return null;
        TreeNode examination = stack.peek();
        if(examination.equals(node)) {
            List<TreeNode> result = new ArrayList();
            for( int i = 0 ; i < stack.size() ; i++ ){
                result.add(stack.get(i));
            }
            return result;
        }
        if(examination != null) {
            if(examination.left != null) {
                stack.push(examination.left);
                List<TreeNode> result = getListToNode(node,stack);
                if(result != null) {
                    return result;
                }
                stack.pop();
            }
            if(examination.right != null) {
                stack.push(examination.right);
                List<TreeNode> result = getListToNode(node,stack);
                if(result != null) {
                    return result;
                }
                stack.pop();
            }
        }
        return null;
    }

    /**
     * parseDistance(L,L') {
     *     for i 0 -> L.length - 1
     *        if(L'.contains(L.get(i))) {
     *            return (L.length - i) + (L'.length - index(L.get(i))) {
     *            }
     *        }
     *    }
     *    return 0;
     * }
     * @param leftList this list
     * @param rightList that list
     * @return the distance between a common point between two nodes.
     */
    private int parseDistance(List<TreeNode> leftList, List<TreeNode> rightList) {
        for(int i = leftList.size() - 1 ; i >= 0 ; i--){
            if(rightList.contains(leftList.get(i))) {
                int where  = rightList.lastIndexOf(leftList.get(i));
                return (leftList.size()-i) + (rightList.size()-where) - 1;
            }
        }
        return 0;
    }

    /**
     * given a node it gives its depth.
     * @param node
     */
    public int getNodeDepth(TreeNode node){
        return getNodeDepthInternal(root, node, 1) + 1;
    }

    private int getNodeDepthInternal(TreeNode node, TreeNode target, int level) {
        if(node.equals(target)){
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
        Stack<TreeNode> leftStack = new Stack<>();
        leftStack.push(root);
        Stack<TreeNode> rightStack = new Stack<>();
        rightStack.push(root);
        List<TreeNode> leftList = getListToNode(thiz, leftStack);
        List<TreeNode> rightList = getListToNode(dat, rightStack);
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
        return 1 + computeHeight(root.left)+computeHeight(root.right);
     }

    public void remove(TreeNode node) {
        removeInternal(this.root,node);
    }

    private void removeInternal(TreeNode root,TreeNode node) {
        if(root.equals(node)) {
            TreeNode penUltimate = root;
            TreeNode ultimate = root.left;
            while(ultimate.left!=null){
                penUltimate = penUltimate.left;
                ultimate = ultimate.left;
            }
            root.number = ultimate.number;
            penUltimate.left = null;
            return;
        }
        if(root.left != null){
            removeInternal(root.left,node);
        }
        if(root.right != null) {
            removeInternal(root.right,node);
        }
    }

    public void aggregate() {
        aggregateInternal(this.root);
    }

    private int aggregateInternal(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return node.number.number;
        if(node.left == null || node.right == null){
            if(node.left != null){
                node.number.number = aggregateInternal(node.left);
            } else {
                node.number.number = aggregateInternal(node.right);
            }
            return node.number.number;
        }
        node.number.number = aggregateInternal(node.left) + aggregateInternal(node.right);
        return node.number.number;
    }

    public int getMaxValue() {
        ComparableNumber maxValue = new ComparableNumber(Integer.MIN_VALUE);
        getMaxValueInternal(this.root,maxValue);
        return maxValue.number;
    }

    public int getMinValue() {
        ComparableNumber minValue = new ComparableNumber(Integer.MAX_VALUE);
        getMinValueInternal(this.root , minValue);
        return minValue.number;
    }

    private void getMinValueInternal(TreeNode node, ComparableNumber minValue) {
        if(node == null) return;
        if(node.number.number < minValue.number) {
            minValue.number = node.number.number;
        }
        getMinValueInternal(node.left , minValue);
        getMinValueInternal(node.right , minValue);
    }

    private void getMaxValueInternal(TreeNode node, ComparableNumber maxValue) {
        if(node == null) return;
        if(node.number.number > maxValue.number) {
            maxValue.number = node.number.number;
        }
        getMaxValueInternal(node.left,maxValue);
        getMaxValueInternal(node.right,maxValue);
    }

    public static BinaryTree newInstancefromPreOrder(int[] preOrder){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = constructBinaryTreeFromPreOrder(preOrder,0,preOrder.length-1);
        return binaryTree;
    }

    private static TreeNode constructBinaryTreeFromPreOrder(int[] preOrder,int start,int end){
        if(end < start){
            return null;
        }
        if(end == start){
            return new TreeNode(preOrder[start]);
        }

        TreeNode root = new TreeNode(preOrder[start]);
        int rightTreeStart = 0;
        for(int j = end ; preOrder[j] > preOrder[start] ; j--) {
            rightTreeStart = j;
        }
        root.right = constructBinaryTreeFromPreOrder(preOrder,rightTreeStart, end);
        root.left = constructBinaryTreeFromPreOrder(preOrder,start+1,rightTreeStart-1);
        return root;
    }

    public static BinaryTree getNewInstanceFromPreAndInOrder(int[] preOrder,int[] inOrder) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = getSubTree(preOrder, inOrder);
        return binaryTree;
    }

    private static TreeNode getSubTree(int[] preOrder,int[] inOrder){
        if(preOrder.length == 3){
            TreeNode root = new TreeNode(preOrder[0]);
            root.left = new TreeNode(preOrder[1]);
            root.right = new TreeNode(preOrder[2]);
            return root;
        }
        if(preOrder.length==2){
            TreeNode root = new TreeNode(preOrder[0]);
            if(inOrder[0] == preOrder[0]){
                root.right = new TreeNode(preOrder[1]);
            }else {
                root.left = new TreeNode(preOrder[1]);
            }
            return root;
        }
        if(preOrder.length==1){
            TreeNode root = new TreeNode(preOrder[0]);
            return root;
        }
        TreeNode root = new TreeNode(preOrder[0]);
        int rootLocationIo = 0;
        for(int i = 0 ; i < inOrder.length ; i++) {
            if(inOrder[i] == preOrder[0]){
                rootLocationIo = i;break;
            }
        }
        int[] leftInOrder = getSubArray(inOrder, 0, rootLocationIo - 1);
        int[] leftPreOrder = getSubArrayFromIo(0,leftInOrder.length,preOrder);
        root.left = getSubTree(leftPreOrder,leftInOrder);

        int[] rightInOrder = getSubArray(inOrder, rootLocationIo +1,inOrder.length-1);
        int[] rightPreOrder = getSubArrayFromIo(leftInOrder.length,rightInOrder.length,preOrder);
        root.right = getSubTree(rightPreOrder,rightInOrder);
        return root;
    }

    private static int[] getSubArrayFromIo(int offset,int length, int[] preOrder) {
        int[] result = new int[length];
        for(int j=0, i = 1+offset ; i < 1+ offset+ length ; i++,j++) {
            result[j] = preOrder[i];
        }
        return result;
    }

    private static int[] getSubArray(int[] inOrder, int start, int end) {
        int[] result = new int[end-start+1];
        for(int i = start,j=0 ; i <=end ;i++,j++ ) {
            result[j] = inOrder[i];
        }
        return result;
    }

    public static BinaryTree merge(BinaryTree thiz , BinaryTree that) {
        BinaryTree response = new BinaryTree();
        response.root = TreeNode.merge(thiz.root , that.root);
        return response;
    }
}
