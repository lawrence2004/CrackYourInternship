package CrackYourInternship.Day4;
import java.util.*;
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    private static void dfs(int node,boolean[] vis,ArrayList<Integer> dfs,ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        dfs.add(node);
        for(int it : adj.get(node)) {
            if(!vis[it]) {
                dfs(it,vis,dfs,adj);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(0,vis,dfs,adj);
        return dfs;
    }
}
