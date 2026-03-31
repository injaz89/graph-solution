package graph;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // require exactly one input file argument
        if (args.length != 1) {
            System.out.println("Usage: ./graph_solution <file>");
            return;
        }

        // parse the graph from the CSV file
        Graph g = GraphParser.parse(args[0]);

        // compute graph properties
        boolean isDag = GraphAnalyzer.isDAG(g);
        int maxIn = GraphAnalyzer.maxInDegree(g);
        int maxOut = GraphAnalyzer.maxOutDegree(g);

        // compute PageRank values and find min/max
        double[] pr = PageRank.compute(g);
        double prMax = Arrays.stream(pr).max().getAsDouble();
        double prMin = Arrays.stream(pr).min().getAsDouble();

        // print results to standard output
        System.out.println("is_dag: " + isDag);
        System.out.println("max_in_degree: " + maxIn);
        System.out.println("max_out_degree: " + maxOut);
        System.out.printf("pr_max: %.6f\n", prMax);
        System.out.printf("pr_min: %.6f\n", prMin);
    }
}