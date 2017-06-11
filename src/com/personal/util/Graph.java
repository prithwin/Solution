package com.personal.util;

import java.util.*;
import java.util.LinkedList;

import static com.personal.util.GraphType.UNDIRECTED_MATRIX;

/**
 * Created by pr250155 on 4/29/17.
 */
public class Graph {

    public Map<Integer, GraphNode> graphNodes;
    public int[][] adjecencyMatrix;
    public List<List<GraphNode>> adjacencyList;
    public GraphType type;

    public Graph(int[][] adjecencyMatrix, Map<Integer, GraphNode> graphNodes) {
        this.adjecencyMatrix = adjecencyMatrix;
        this.graphNodes = graphNodes;
        this.type = UNDIRECTED_MATRIX;
    }

    public Graph(Map<Integer, GraphNode> graphNodes, GraphType type) {
        if (type.isMatrix()) {
            if (adjecencyMatrix == null) {
                adjecencyMatrix = new int[graphNodes.size()][graphNodes.size()];
            }
        }
        this.graphNodes = graphNodes;
        this.type = type;
    }

    public void addEdge(int a, int b) {
        if (type.isDirected()) {
            if (type.isMatrix()) {
                adjecencyMatrix[a][b] = 1;
            }
        } else {
            if (type.isMatrix()) {
                adjecencyMatrix[a][b] = 1;
                adjecencyMatrix[b][a] = 1;
            }
        }
    }

    public void addWeightedEdge(int a, int b, int weight) {
        if (type.isDirected()) {
            if (type.isMatrix()) {
                adjecencyMatrix[a][b] = weight;
            }
        } else {
            if (type.isMatrix()) {
                adjecencyMatrix[a][b] = weight;
                adjecencyMatrix[b][a] = weight;
            }
        }
    }

    public void printDepthFirstSearch(int index) {
        if (type.isMatrix()) {
            printDepthFirstSearchInternal(index, new ArrayList<>());
        }
    }

    public void printBreadthFirstSearch(int index) {
        if (type.isMatrix()) {
            Queue<Integer> printQueue = new java.util.LinkedList();
            List<Integer> visited = new ArrayList();
            printQueue.add(index);
            bfsInternal(printQueue, visited);
        }
    }

    public boolean isCyclicGraph() {
        if (type.isMatrix()) {
            if (type == GraphType.UNDIRECTED_MATRIX) {
                DisjointSet checker = new DisjointSet(adjecencyMatrix.length);
                List<ComparableEdge> comparableEdges = getAsListOfComparableEdges();
                for (ComparableEdge edge : comparableEdges) {
                    if (checker.find(edge.from) != checker.find(edge.to)) {
                        checker.union(edge.from, edge.to);
                    } else {
                        return true;
                    }
                }
                return false;
            } else {
                return containsCycles(0, new ArrayList<>());
            }
        }
        return false;
    }

    private void bfsInternal(Queue<Integer> printQueue, List<Integer> visited) {
        if (printQueue.isEmpty()) return;
        int index = printQueue.poll();
        System.out.println(graphNodes.get(index).readableName);
        visited.add(index);
        for (int j = 0; j < adjecencyMatrix[index].length; j++) {
            if (adjecencyMatrix[index][j] != 0) {
                if (!visited.contains(j)) {
                    printQueue.offer(j);
                }
            }
        }
        bfsInternal(printQueue, visited);
    }

    private void printDepthFirstSearchInternal(int index, List<Integer> visited) {
        System.out.println(graphNodes.get(index).readableName);
        visited.add(index);
        for (int j = 0; j < adjecencyMatrix[index].length; j++) {
            if (adjecencyMatrix[index][j] != 0) {
                //there is an edge
                if (!visited.contains(j)) {
                    printDepthFirstSearchInternal(j, visited);
                }
            }
        }
    }

    private boolean containsCycles(int index, List<Integer> visited) {
        visited.add(index);
        for (int j = 0; j < adjecencyMatrix[index].length; j++) {
            if (adjecencyMatrix[index][j] != 0) {
                //there is an edge
                if (!visited.contains(j)) {
                    containsCycles(j, visited);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCycles() {
        return false;
    }

    /**
     * Kruskal's MST Algorithm implementation.
     * The Classic Algorithm Can be explained as follows.
     * SL = mergeSort(Es)
     * DEFINE MST = _;
     * for(E in Es) {
     *     if(isAcyclic(MST + E)) {
     *         MST.add(E);
     *     }
     * }
     * @return A graph representing the minimum spanning Tree for this Graph(new Instance)
     */
    public Graph getKruskalMST() {
        if (type.isDirected()) {
            throw new UnsupportedOperationException("Kruskal's Algorithm only works for undirected graphs");
        }
        if (type.isMatrix()) {
            int[][] result = new int[adjecencyMatrix.length][adjecencyMatrix[0].length];
            DisjointSet checker = new DisjointSet(adjecencyMatrix.length);

            List<ComparableEdge> comparableEdges = getAsListOfComparableEdges();
            List<ComparableEdge> sortedList = new Sorter<ComparableEdge>().mergeSort(comparableEdges);

            for (ComparableEdge edge : sortedList) {
                if (checker.find(edge.from) != checker.find(edge.to)) {
                    checker.union(edge.from, edge.to);
                    result[edge.from][edge.to] = edge.weight;
                    result[edge.to][edge.from] = edge.weight;
                }
            }
            return new Graph(result, this.graphNodes);

        }
        return new Graph(null, GraphType.UNDIRECTED_LIST);
    }

    private List<ComparableEdge> getAsListOfComparableEdges() {
        List<ComparableEdge> edgeList = new LinkedList();
        if (type.isMatrix()) {
            for (int i = 0; i < adjecencyMatrix.length; i++) {
                for (int j = 0; j < adjecencyMatrix[i].length; j++) {
                    if (j >= i) {
                        if (adjecencyMatrix[i][j] != 0) {
                            ComparableEdge edge = new ComparableEdge();
                            edge.from = i;
                            edge.to = j;
                            edge.weight = adjecencyMatrix[i][j];
                            edgeList.add(edge);
                        }
                    }
                }
            }
        }
        return edgeList;
    }

    /**
     * An implementation of Prim's minimum Spanning Tree algorithm.
     * The Classic algorithm can be described as follows:
     * DEFINE reducableHeap RH;
     * DEFINE edgeStore;
     * INITIALIZE RH (n, INFINITY)
     * while(!RH.empty) {
     *     Node = RH.deleteMin();
     *     for(Node Adjecent to Node) {
     *         if(W(N-A) < RH.n.w) {
     *             RH.reducingHeapify();
     *             edgeStore.put(A,A-E);
     *         }
     *     }
     * }
     *
     *
     * @return Prim's Minimum Spanning Tree.
     */
    public Graph getPrimsMST() {
        if (type.isDirected()) {
            throw new UnsupportedOperationException("Prims's Algorithm only works for undirected graphs");
        }
        if (type.isMatrix()) {
            int[][] result = new int[adjecencyMatrix.length][adjecencyMatrix[0].length];
            Map<Integer, ComparableEdge> edgesStore = new HashMap<>();
            UpdatableHeap<NodeDistance> minHeap = new UpdatableHeap<>(getListOfNodeWeights(edgesStore));
            while (!minHeap.isEmpty()) {
                NodeDistance minElement = minHeap.deleteMin();
                //add this to the result
                ComparableEdge minEdge = edgesStore.get(minElement.node);
                result[minEdge.from][minEdge.to] = minEdge.weight;
                result[minEdge.to][minEdge.from] = minEdge.weight;
                for (int j = 0; j < adjecencyMatrix[minElement.node].length; j++) {
                    if (adjecencyMatrix[minElement.node][j] == 0) {
                        continue;
                    }
                    NodeDistance toUpdate = new NodeDistance(j, adjecencyMatrix[minElement.node][j]);
                    if (minHeap.reduceKey(toUpdate, adjecencyMatrix[minElement.node][j])) {
                        edgesStore.put(toUpdate.node, new ComparableEdge(minElement.node, j, adjecencyMatrix[minElement.node][j]));
                    }

                }
            }
            return new Graph(result, this.graphNodes);
        }
        return new Graph(null, GraphType.UNDIRECTED_LIST);
    }

    public List<NodeDistance> getListOfNodeWeights(Map<Integer, ComparableEdge> edgeMap) {
        List<NodeDistance> nodeDistances = new ArrayList<>();
        for (Integer key : graphNodes.keySet()) {
            nodeDistances.add(new NodeDistance(key, Integer.MAX_VALUE));
        }
        //set some starting node
        nodeDistances.get(0).weight = 0;
        edgeMap.put(nodeDistances.get(0).node, new ComparableEdge(0, 0, 0));
        return nodeDistances;
    }
}
