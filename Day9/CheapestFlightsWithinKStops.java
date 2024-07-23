import java.util.*;
class Pair {
    int stops, node, dis;
    Pair(int stops, int node, int dis) {
        this.stops = stops;
        this.node = node;
        this.dis = dis;
    }
}
class Tuple {
    int first, second;
    Tuple(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Tuple>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        int m = flights.length;
        for(int i = 0;i<m;i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            adj.get(u).add(new Tuple(v, wt));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        while(!q.isEmpty()) {
            Pair it = q.poll();
            int stops = it.stops;
            int node = it.node;
            int dis = it.dis;
            if(stops > k) continue;
            for(Tuple iter : adj.get(node)) {
                int adjNode = iter.first;
                int wt = iter.second;
                if(dis + wt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = dis + wt;
                    q.add(new Pair(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}