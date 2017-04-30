package com.personal;

import com.personal.util.Graph;
import com.personal.util.GraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pr250155 on 4/30/17.
 */
public class GraphTester {
    public static void main(String[] args) {
        Map<Integer,GraphNode> nodeMap = new HashMap<>();
        int[][] adjacencyMatrix = { {0,1,1,0},
                                    {0,0,1,0},
                                    {1,0,0,1},
                                    {0,0,0,1}};
        nodeMap.put(0,new GraphNode("0"));
        nodeMap.put(1,new GraphNode("1"));
        nodeMap.put(2,new GraphNode("2"));
        nodeMap.put(3,new GraphNode("3"));

        Graph graph = new Graph(adjacencyMatrix , nodeMap);
        graph.printDepthFirstSearch(2);

    }
}
