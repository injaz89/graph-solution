package graph;

import java.util.*;

public class GraphAnalyzer {

    public static boolean isDAG(Graph g) {
        // detect cycles using node visitation state
        Map<Integer, Integer> state = new HashMap<>();

        for (int node : g.nodes) {
            if (dfs(node, g, state)) return false;
        }
        return true;
    }

    private static boolean dfs(int node, Graph g, Map<Integer, Integer> state) {
        if (state.getOrDefault(node, 0) == 1) return true;
        if (state.getOrDefault(node, 0) == 2) return false;

        state.put(node, 1);

        for (int nei : g.adj.getOrDefault(node, new ArrayList<>())) {
            if (dfs(nei, g, state)) return true;
        }

        state.put(node, 2);
        return false;
    }

    public static int maxInDegree(Graph g) {
        // find the largest in-degree across all nodes
        int max = 0;
        for (int v : g.inDegree.values()) {
            max = Math.max(max, v);
        }
        return max;
    }

    public static int maxOutDegree(Graph g) {
        // find the largest out-degree across all nodes
        int max = 0;
        for (int v : g.outDegree.values()) {
            max = Math.max(max, v);
        }
        return max;
    }
}