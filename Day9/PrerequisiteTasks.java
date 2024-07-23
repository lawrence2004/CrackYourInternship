import java.util.*;
class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<N;i++) adj.add(new ArrayList<>());
        for(int i = 0;i<P;i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree = new int[N];
        for(int i = 0;i<N;i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        int cnt  = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            for(int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        if(N != cnt) return false;
        return true;
    }
    
}