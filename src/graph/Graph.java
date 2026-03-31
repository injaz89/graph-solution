package graph;

import java.util.*;

public class Graph {
    // adjacency list representation for directed edges
    public Map<Integer, List<Integer>> adj = new HashMap<>();
    // counts of incoming edges per node
    public Map<Integer, Integer> inDegree = new HashMap<>();
    // counts of outgoing edges per node
    public Map<Integer, Integer> outDegree = new HashMap<>();
    // set of all nodes seen in the graph
    public Set<Integer> nodes = new HashSet<>();
}