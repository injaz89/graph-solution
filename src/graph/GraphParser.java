package graph;

import java.io.*;
import java.util.*;

public class GraphParser {

    public static Graph parse(String path) throws Exception {
        // build graph representation from CSV edge list
        Graph g = new Graph();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);

            g.adj.putIfAbsent(u, new ArrayList<>());
            g.adj.putIfAbsent(v, new ArrayList<>());

            g.adj.get(u).add(v);

            g.nodes.add(u);
            g.nodes.add(v);

            g.outDegree.put(u, g.outDegree.getOrDefault(u, 0) + 1);
            g.outDegree.putIfAbsent(v, g.outDegree.getOrDefault(v, 0));

            g.inDegree.put(v, g.inDegree.getOrDefault(v, 0) + 1);
            g.inDegree.putIfAbsent(u, g.inDegree.getOrDefault(u, 0));
        }

        br.close();
        return g;
    }
}