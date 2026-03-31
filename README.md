 Graph Processing Solution

This project implements a directed graph processing utility for the Ren engineering challenge.

It reads a graph from a CSV file and computes key structural and algorithmic properties.

---

 🚀 Features

* Parse directed graph from CSV input
* Detect if the graph is a DAG (Directed Acyclic Graph)
* Compute:

  * Maximum in-degree
  * Maximum out-degree
* Implement PageRank algorithm:

  * Damping factor: 0.85
  * 20 iterations
  * Handles dangling nodes
* Outputs results in exact required format

---

 📁 Project Structure

```
graph-solution/
├── graph_solution
├── src/graph/
│   ├── Main.java
│   ├── Graph.java
│   ├── GraphParser.java
│   ├── GraphAnalyzer.java
│   └── PageRank.java
├── test_cases/
│   ├── graph1.csv
│   ├── graph2.csv
│   ├── graph3.csv
├── README.md
```

---

 ⚙️ Requirements

* Java 8 or higher
* Unix-like environment (Linux/macOS) for script execution

---

 ▶️ How to Run

 1. Make script executable

```
chmod +x graph_solution
```

 2. Run the program

```
./graph_solution test_cases/graph1.csv
```

---

 📌 Output Format

The program prints exactly:

```
is_dag: true/false
max_in_degree: <integer>
max_out_degree: <integer>
pr_max: <float>
pr_min: <float>
```

All PageRank values are rounded to 6 decimal places.

---

 🧠 Implementation Details

* Graph stored using adjacency list
* DFS used for cycle detection (DAG check)
* Degree calculations tracked during parsing
* PageRank implemented manually (no external libraries)
* Handles dangling nodes by distributing probability evenly

---

 🧪 Testing

Test files are provided in the `test_cases/` directory.

Example:

```
./graph_solution test_cases/graph1.csv
```

Compare output with expected results.

---

 📦 Submission Notes

* The project runs with a single command:

  ```
  ./graph_solution <input_file>
  ```
* Compilation happens automatically on first run
* No external dependencies required

---

👤 Author

* Your Name
