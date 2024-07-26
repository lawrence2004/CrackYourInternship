package CrackYourInternship.Day12;

import java.util.*;
class Pair {
    int row, col, time;
    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution
{
    private boolean isValid(int newr, int newc, int n, int m) {
        return newr >= 0 && newr < n && newc >= 0 && newc < m;
    }
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int freshOranges = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(grid[i][j] == 1) freshOranges++;
                else if(grid[i][j] == 2) {
                    vis[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int rottenedOranges = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int maxTime = 0;
        while(!q.isEmpty()) {
            Pair it = q.poll();
            int row = it.row;
            int col = it.col;
            int time = it.time;
            maxTime = Math.max(maxTime, time);
            for(int i = 0;i<4;i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];
                if(isValid(newr, newc, n, m) && grid[newr][newc] == 1 && vis[newr][newc] == 0) {
                    q.add(new Pair(newr, newc, time + 1));
                    vis[newr][newc] = 1;
                    rottenedOranges++;
                }
            }
        }
        if(freshOranges != rottenedOranges) return -1;
        return maxTime;
    }
}
