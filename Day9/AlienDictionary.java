package CrackYourInternship.Day9;

import java.util.*;
class Solution
{
    public List<Integer> topoSort(List<List<Integer>> adj, int K) {
        int[] indegree = new int[K];
        for(int i = 0;i<K;i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<K;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<Integer>();
        while(!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);
            for(int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return topo;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<K;i++) adj.add(new ArrayList<>());
        for(int i = 1;i<N;i++) {
            String a = dict[i - 1];
            String b = dict[i];
            int len = Math.min(a.length(), b.length());
            for(int ptr = 0;ptr<len;ptr++) {
                if(a.charAt(ptr) != b.charAt(ptr)) {
                    adj.get(a.charAt(ptr) - 'a').add(b.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(adj, K);
        String str = "";
        for(int it : topo) {
            str += (char)(it + (int)('a'));
        }
        return str;
    }
}
