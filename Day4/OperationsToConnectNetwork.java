package CrackYourInternship.Day4;

import java.util.*;
class Solution {
    public static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for(int it : adj.get(node)) {
            if(vis[it] == 0) dfs(it, vis, adj);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(m < n - 1) return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int i = 0;i<m;i++) {
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        int[] vis = new int[n];
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            if(vis[i] == 0) {
                cnt++;
                dfs(i, vis, adj);
            }
        }
        return cnt - 1;
    }
}
