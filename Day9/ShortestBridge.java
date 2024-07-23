package CrackYourInternship.Day9;

import java.util.*;
class Pair {
    int row;
    int col;
    int flips;
    Pair(int row, int col, int flips) {
        this.row = row;
        this.col = col;
        this.flips = flips;
    }
}
class Solution {
    public void dfs(int row, int col, int[][] vis, int[][] grid, int n, int m, int[] dx, int[] dy) {
        vis[row][col] = 1;
        for(int i = 0;i<4;i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, vis, grid, n, m, dx, dy);
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int dx[] = {-1, 0, +1, 0};
        int dy[] = {0, +1, 0, -1};
        boolean flag = true;
        for(int i = 0;i<n && flag;i++) {
            for(int j = 0;j<n && flag;j++) {
                if(grid[i][j] == 1) {
                    dfs(i, j, vis, grid, n, m, dx, dy);
                    flag = false;
                }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                if(grid[i][j] == 1 && vis[i][j] == 1) {
                    q.offer(new Pair(i, j, 0));
                }
            }
        }
        while(!q.isEmpty()) {
            Pair it = q.peek();
            int row = it.row;
            int col = it.col;
            int flips = it.flips;
            q.poll();
            for(int i = 0;i<4;i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(grid[nr][nc] == 1 && vis[nr][nc] == 0) return flips;
                    if(grid[nr][nc] == 0 && vis[nr][nc] == 0) {
                        q.offer(new Pair(nr, nc, flips + 1));
                        vis[nr][nc] = 1;
                    }
                }
            }
        }
        return -1;
    }
}