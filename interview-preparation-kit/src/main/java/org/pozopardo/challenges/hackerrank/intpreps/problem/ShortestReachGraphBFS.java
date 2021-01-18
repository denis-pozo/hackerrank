package org.pozopardo.challenges.hackerrank.intpreps.problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReachGraphBFS {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int nQueries = Integer.parseInt(scanner.nextLine().trim());
        for(int queryIter = 0; queryIter < nQueries; queryIter++) {
            String[] aux = scanner.nextLine().split(" ");
            int nNodes = Integer.parseInt(aux[0]);
            int nEdges = Integer.parseInt(aux[1]);

            int[][] edges = new int[nEdges][2];
            for(int edgeIter = 0; edgeIter < nEdges; edgeIter++) {
                String[] edge = scanner.nextLine().split(" ");
                edges[edgeIter][0] = Integer.parseInt(edge[0]);
                edges[edgeIter][1] = Integer.parseInt(edge[1]);
            }

            int startIndex = Integer.parseInt(scanner.nextLine().trim());
            Graph graph = new Graph(nNodes, edges);
            int [] shortestPaths = graph.shortestReach(startIndex);

            for(int i = 0; i < shortestPaths.length; i++) {
                if(shortestPaths[i] != 0) {
                    bufferedWriter.write(String.valueOf(shortestPaths[i]));
                    if(i != shortestPaths.length-1) {
                        bufferedWriter.write(" ");
                    }
                }
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.close();
    }
}

class Graph {

    private final HashMap<Integer, Node> nodes = new HashMap<>();
    private static final int COST = 6;

    public Graph(int nodes, int [][] edges) {

        for(int i = 1; i <= nodes; i++) {
            Node node = new Node(i);
            this.nodes.put(i, node);
        }

        for(int i = 0; i < edges.length; i++) {
            Node u = this.nodes.get(edges[i][0]);
            Node v = this.nodes.get(edges[i][1]);
            u.getAdjacents().add(v);
            v.getAdjacents().add(u);
            this.nodes.put(u.getIndex(), u);
            this.nodes.put(v.getIndex(), v);
        }
    }

    public int[] shortestReach(int sourceId) {
        int[] distances = new int[nodes.size()];
        Arrays.fill(distances, -1);
        distances[sourceId-1] = 0;

        Queue<Node> queue = new LinkedList<>();
        Node source = nodes.get(sourceId);
        queue.add(source);

        HashSet<Integer> visited = new HashSet<>();
        visited.add(sourceId);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node node : nodes.get(currentNode.getIndex()).getAdjacents()){
                if(!visited.contains(node.getIndex())) {
                    queue.offer(node);
                    visited.add(node.getIndex());
                    distances[node.getIndex() - 1] = distances[currentNode.getIndex() - 1] + COST;
                }
            }
        }

        return distances;
    }

    public int size() {
        return nodes.size();
    }

    public Node getNode(int index) {
        return nodes.get(index);
    }
}

class Node {
    private final int index;
    private final List<Node> adjacents;

    public Node(int index) {
        this.index = index;
        adjacents = new ArrayList<Node>();
    }

    public void add(Node node) {
        adjacents.add(node);
    }

    public int getIndex() {
        return index;
    }

    public List<Node> getAdjacents() {
        return adjacents;
    }
}
