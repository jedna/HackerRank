/*
Consider an undirected graph consisting of  nodes where each node is labeled from  to  and the edge between any two nodes is always of length . We define node  to be the starting position for a BFS.

Given  queries in the form of a graph and some starting node, , perform each query by calculating the shortest distance from starting node  to all the other nodes in the graph. Then print a single line of  space-separated integers listing node 's shortest distance to each of the  other nodes (ordered sequentially by node number); if  is disconnected from a node, print  as the distance to that node.

Input Format

The first line contains an integer, , denoting the number of queries. The subsequent lines describe each query in the following format:

The first line contains two space-separated integers describing the respective values of  (the number of nodes) and  (the number of edges) in the graph.
Each line  of the  subsequent lines contains two space-separated integers,  and , describing an edge connecting node  to node .
The last line contains a single integer, , denoting the index of the starting node.
Constraints

Output Format

For each of the  queries, print a single line of  space-separated integers denoting the shortest distances to each of the  other nodes from starting position . These distances should be listed sequentially by node number (i.e., ), but should not include node . If some node is unreachable from , print  as the distance to that node.

Sample Input

2
4 2
1 2
1 3
1
3 1
2 3
2

Sample Output

6 6 -1
-1 6
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        Node[] nodes;   
        
        public Graph(int size) {
            nodes = new Node[size];
            
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        public void addEdge(int first, int second) {
            nodes[first].adjacents.add(second);
            nodes[second].adjacents.add(first);
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            int[] d = new int[nodes.length];
            Queue<Node> stack = new LinkedList<Node>();
            
            Arrays.fill(d, -1);
            stack.offer(nodes[startId]);
            d[startId] = 0;
            
            while (! stack.isEmpty()) {
                Node head = stack.poll();
                for (int adjacent : head.adjacents) {
                    if (d[adjacent] < 0) {
                        d[adjacent] = d[head.id] + 6;
                        stack.offer(nodes[adjacent]);
                    }
                }
            }
            
            //System.out.println(startId);
            
            return d;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}

class Node {
    int id;
    List<Integer> adjacents = new ArrayList<Integer>();
    int distance = -1;
    
    Node(int id) {
        this.id = id;
    }
}
