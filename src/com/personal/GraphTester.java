package com.personal;

import com.personal.util.Graph;
import com.personal.util.GraphNode;
import com.personal.util.GraphType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 4/30/17.
 */
public class GraphTester {
    public static void main(String[] args) {
        Map<Integer,GraphNode> nodeMap = new HashMap<>();

        nodeMap.put(0,new GraphNode("0"));
        nodeMap.put(1,new GraphNode("1"));
        nodeMap.put(2,new GraphNode("2"));
        nodeMap.put(3,new GraphNode("3"));

        Graph graph = new Graph(nodeMap, GraphType.UNDIRECTED_MATRIX);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,0);
        graph.addEdge(3,3);

        graph.printDepthFirstSearch(2);

    }
}
