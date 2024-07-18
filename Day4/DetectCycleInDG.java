package CrackYourInternship.Day4;

import java.util.*;
class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for(int i = 0;i<V;i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0;i<V;i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            for(int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        if(cnt != V) return true;
        return false;
    }
}
