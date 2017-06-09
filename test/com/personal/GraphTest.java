package com.personal;

import com.personal.util.*;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 4/30/17.
 */
public class GraphTest {
    @Test public void testDFS() {
        Map<Integer,GraphNode> nodeMap = new HashMap<>();

        nodeMap.put(0,new GraphNode("0"));
        nodeMap.put(1,new GraphNode("1"));
        nodeMap.put(2,new GraphNode("2"));
        nodeMap.put(3,new GraphNode("3"));

        Graph graph = new Graph(nodeMap, GraphType.DIRECTED_MATRIX);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,0);
        graph.addEdge(3,3);

        graph.printDepthFirstSearch(2);
        System.out.println();

    }

    @Test public void testBFS() {
        Map<Integer,GraphNode> nodeMap = new HashMap<>();

        nodeMap.put(0,new GraphNode("0"));
        nodeMap.put(1,new GraphNode("1"));
        nodeMap.put(2,new GraphNode("2"));
        nodeMap.put(3,new GraphNode("3"));

        Graph graph = new Graph(nodeMap, GraphType.DIRECTED_MATRIX);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        graph.printBreadthFirstSearch(2);

    }

    @Test public void checkCyclicGraph() {
        Map<Integer,GraphNode> nodeMap = new HashMap<>();
        nodeMap.put(0,new GraphNode("0"));
        nodeMap.put(1,new GraphNode("1"));
        nodeMap.put(2,new GraphNode("2"));
        nodeMap.put(3,new GraphNode("3"));

        Graph graph = new Graph(nodeMap, GraphType.DIRECTED_MATRIX);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        assertTrue(graph.isCyclicGraph());
    }

    @Test public void testUndiredtedCycle() {
        Map<Integer,GraphNode> nodeMap = new HashMap<>();
        nodeMap.put(0,new GraphNode("0"));
        nodeMap.put(1,new GraphNode("1"));
        nodeMap.put(2,new GraphNode("2"));
        nodeMap.put(3,new GraphNode("3"));
        nodeMap.put(4,new GraphNode("4"));

        Graph graph = new Graph(nodeMap, GraphType.UNDIRECTED_MATRIX);

        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        assertTrue(graph.isCyclicGraph());
    }

    @Test public void testStraightGraph() {
        Map<Integer,GraphNode> nodeMap = new HashMap<>();
        nodeMap.put(0,new GraphNode("0"));
        nodeMap.put(1,new GraphNode("1"));
        nodeMap.put(2,new GraphNode("2"));

        Graph graph = new Graph(nodeMap, GraphType.UNDIRECTED_MATRIX);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        assertFalse(graph.isCyclicGraph());
    }

    @Test public void testKruskalMST() {
        Map<Integer,GraphNode> nodeMap = new HashMap<>();
        nodeMap.put(0,new GraphNode("0"));
        nodeMap.put(1,new GraphNode("1"));
        nodeMap.put(2,new GraphNode("2"));
        nodeMap.put(3,new GraphNode("3"));

        Graph graph = new Graph(nodeMap, GraphType.UNDIRECTED_MATRIX);

        graph.addWeightedEdge(0,1,10);
        graph.addWeightedEdge(0,2,6);
        graph.addWeightedEdge(0,3,5);
        graph.addWeightedEdge(1,3,15);
        graph.addWeightedEdge(2,3,4);

        Graph mst = graph.getKruskalMST();
        MatrixUtil.print2dMatrix(graph.adjecencyMatrix);
        MatrixUtil.print2dMatrix(mst.adjecencyMatrix);
        System.out.println("check");
    }

    @Test public void testPrimsMST() {
        Map<Integer,GraphNode> nodeMap = new HashMap<>();
        nodeMap.put(0,new GraphNode("0"));
        nodeMap.put(1,new GraphNode("1"));
        nodeMap.put(2,new GraphNode("2"));
        nodeMap.put(3,new GraphNode("3"));

        Graph graph = new Graph(nodeMap, GraphType.UNDIRECTED_MATRIX);

        graph.addWeightedEdge(0,1,10);
        graph.addWeightedEdge(0,2,6);
        graph.addWeightedEdge(0,3,5);
        graph.addWeightedEdge(1,3,15);
        graph.addWeightedEdge(2,3,4);

        Graph mst = graph.getPrimsMST();
        MatrixUtil.print2dMatrix(graph.adjecencyMatrix);
        MatrixUtil.print2dMatrix(mst.adjecencyMatrix);
        System.out.println("check");
    }
}
