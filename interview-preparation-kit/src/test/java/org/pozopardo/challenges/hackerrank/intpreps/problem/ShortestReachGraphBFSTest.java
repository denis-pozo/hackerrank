package org.pozopardo.challenges.hackerrank.intpreps.problem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShortestReachGraphBFSTest {

    @Test
    public void testCase00() {
        int nNodes = 4;
        int nEdges = 2;
        int [][] edges = new int[nEdges][2];
        edges[0] = new int[]{1, 2};
        edges[1] = new int[]{1, 3};
        Graph graph = new Graph(nNodes, edges);

        assertEquals(4, graph.size());
        assertEquals(2, graph.getNode(1).getAdjacents().size());
        assertEquals(1, graph.getNode(2).getAdjacents().size());
        assertEquals(1, graph.getNode(3).getAdjacents().size());
        assertEquals(0, graph.getNode(4).getAdjacents().size());

        int [] result = graph.shortestReach(1);
        assertEquals(4, result.length);
        assertEquals(0, result[0]);
        assertEquals(6, result[1]);
        assertEquals(6, result[2]);
        assertEquals(-1, result[3]);
    }

}
