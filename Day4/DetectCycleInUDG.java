package CrackYourInternship.Day4;

import java.util.*;
class Pair {
    int val;
    int parent;
    Pair(int val,int parent) {
        this.val = val;
        this.parent = parent;
    }
}
class Solution {
    private static boolean checkForCycle(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        Queue<Pair> q= new ArrayDeque<>();
        q.offer(new Pair(node,-1));
        while(!q.isEmpty()) {
            int val = q.peek().val;
            int parent = q.peek().parent;
            q.poll();
            for(int adjNode : adj.get(val)) {
                if(vis[adjNode] == false) {
                    q.offer(new Pair(adjNode,val));
                    vis[adjNode] = true;
                }
                else if(parent != adjNode) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i = 0;i<V;i++) {
            if(!vis[i]) {
                if(checkForCycle(i,vis,adj)) return true;
            }
        }
        return false;
    }
}
