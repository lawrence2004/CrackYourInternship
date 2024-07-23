package CrackYourInternship.Day9;

import java.util.*;
class Solution
{
    public int check(int src, int[][] edges, int n, int[] vis) {
        int dist[] = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        vis[src] = 1;
        for(int i = 0;i<n-1;i++) {
            for(int[] it : edges) {
                int u = it[0];
                int v = it[1];
                int wt = it[2];
                if(dist[u] != (int)1e9 && dist[u] + wt < dist[v]) {
                    vis[v] = 1;
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            if(dist[u] != (int)1e9 && dist[u] + wt < dist[v]) {
                return 1;
            }    
        }
        return 0;
    }
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int vis[] = new int[n];
        for(int i = 0;i<n;i++) {
            if(vis[i] == 0) {
                if(check(i, edges, n, vis) == 1) return 1;
            }
        }
        return 0;
    }
}
