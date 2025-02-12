package CrackYourInternship.Day9;

import java.util.*;
class Solution
{
    public boolean dfs(int node, int col, ArrayList<ArrayList<Integer>>adj, int[] color) {
        color[node] = col;
        for(int it : adj.get(node)) {
            if(color[it] == -1) {
                if(!dfs(it, 1 - col, adj, color)) return false;
            }
            else if(color[it] == color[node]) return false;
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];
        Arrays.fill(color, -1);
        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                if(!dfs(i, 0, adj, color)) return false;
            }
        }
        return true;
    }
}
