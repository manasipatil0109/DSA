/*
 * 1971. Find if Path Exists in Graph

There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 

Example 1:


Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
Example 2:


Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.
 */


package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Path_Exists_Graph {
    /*
     * Solution 1 - BFS , List
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)
            return true;
        
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++)
            g.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i:g.get(temp)){
                if(!visited[i]){
                    visited[i]=true;
                    if(i==destination)
                        return true;
                    q.add(i);
                }
            }
        }
        return visited[destination];
    }


    /*
     * Solution 2 - BFS, Adj Matric - but this solution gives memory limit exceeded issue
     */
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        if(source==destination)
            return true;
        int[][] adj = new int[n][n];
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]][edges[i][1]]=1;
            adj[edges[i][1]][edges[i][0]]=1;
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[source]=true;
        q.add(source);
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=0;i<n;i++){
                if(adj[temp][i]==1 && !visited[i]){
                    if(i==destination)
                        return true;
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
        return visited[destination];
    }


    /*
     * Solution 3 - DFS, LinkedList - faster than bfs
     */
    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        if(source==destination)
            return true;
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++)
            g.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> s = new Stack<>();

        visited[source]=true;
        s.push(source);
        while(!s.isEmpty()){
            int temp = s.pop();
            for(int i:g.get(temp)){
                if(!visited[i]){
                    visited[i]=true;
                    s.push(i);
                    if(visited[destination])
                        return true;
                }
            }
        }
        return visited[destination];
    }
}
