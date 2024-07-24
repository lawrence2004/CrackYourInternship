package CrackYourInternship.Day10;

import java.util.*;
class Pair {
    int distance, node;
    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        pq.add(new Pair(0, 0));
        int[] vis = new int[V];
        int sum = 0;
        while(!pq.isEmpty()) {
            Pair it = pq.poll();
            int node = it.node;
            int distance = it.distance;
            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += distance;
            for(int[] edge : adj.get(node)) {
                int edWt = edge[1];
                int v = edge[0];
                if(vis[v] == 0) {
                    pq.add(new Pair(edWt, v));
                }
            }
        }
        return sum;
    }
}
