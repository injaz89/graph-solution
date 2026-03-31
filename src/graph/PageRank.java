package graph;

import java.util.*;

public class PageRank {

    public static double[] compute(Graph g) {
        // compute PageRank over the graph with a fixed number of iterations
        int N = g.nodes.size();
        List<Integer> nodeList = new ArrayList<>(g.nodes);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nodeList.size(); i++) {
            indexMap.put(nodeList.get(i), i);
        }

        double[] pr = new double[N];
        Arrays.fill(pr, 1.0 / N);

        double d = 0.85;

        for (int iter = 0; iter < 20; iter++) {
            double[] newPr = new double[N];

            for (int i = 0; i < N; i++) {
                newPr[i] = (1 - d) / N;
            }

            for (int u : g.nodes) {
                int uIdx = indexMap.get(u);
                List<Integer> neighbors = g.adj.getOrDefault(u, new ArrayList<>());

                if (neighbors.size() == 0) {
                    // distribute sink node rank evenly to all nodes
                    for (int i = 0; i < N; i++) {
                        newPr[i] += d * (pr[uIdx] / N);
                    }
                } else {
                    for (int v : neighbors) {
                        int vIdx = indexMap.get(v);
                        newPr[vIdx] += d * (pr[uIdx] / neighbors.size());
                    }
                }
            }

            pr = newPr;
        }

        return pr;
    }
}