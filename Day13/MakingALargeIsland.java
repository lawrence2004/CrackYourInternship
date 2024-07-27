package CrackYourInternship.Day13;

import java.util.*;
class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i = 0;i<n;i++) {
            size.add(1);
            parent.add(i);
        }
    } 
    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
class Solution {
    private boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newc >= 0 && newr < n && newc < n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        for(int row = 0;row<n;row++) {
            for(int col = 0;col<n;col++) {
                if(grid[row][col] == 0) continue;
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                for(int ind = 0;ind<4;ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if(isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeNo= row * n + col;
                        int adjNodeNo = newr * n + newc;
                        if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int row = 0;row<n;row++) {
            for(int col = 0;col<n;col++) {
                if(grid[row][col] == 1) continue;
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                Set<Integer> st = new HashSet<>();
                for(int ind = 0;ind<4;ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if(isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int adjNodeNo = newr * n + newc;
                        st.add(ds.findUPar(adjNodeNo));
                    }
                }
                int sum = 0;
                for(Integer it : st) {
                    sum += ds.size.get(it);
                }
                max = Math.max(max, sum + 1);
            }
        }
        for(int i = 0;i<n*n;i++) {
            max = Math.max(max, ds.size.get(ds.findUPar(i)));
        }
        return max;
    }
}