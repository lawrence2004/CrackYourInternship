import java.util.*;
class Solution
{
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st, int V) {
        vis[node] = 1;
        for(int it : adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it, adj, vis, st, V);
            }
        }
        st.add(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                dfs(i, adj, vis, st, V);
            }
        }
        int topo[] = new int[V];
        int i = 0;
        while(!st.isEmpty()) {
            topo[i++] = st.pop();
        }
        return topo;
    }
}