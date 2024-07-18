import java.util.*;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>(0);
        q.offer(0);
        vis[0] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);
            for(int it : adj.get(node)) {
                if(!vis[it]) {
                    q.offer(it);
                    vis[it] = true;
                }
            }
        }
        return bfs;
    }
}