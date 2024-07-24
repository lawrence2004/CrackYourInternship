import java.util.*;
class Pair {
    int row, col, steps;
    Pair(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][n];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                if(grid[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int dx[] = {-1, 0, +1, 0};
        int dy[] = {0, +1, 0, -1};
        int maxSteps = -1;
        while(!q.isEmpty()) {
            Pair it = q.poll();
            int row = it.row;
            int col = it.col;
            int steps = it.steps;
            maxSteps = Math.max(maxSteps, steps);
            for(int i = 0;i<4;i++) {
                int nr = dx[i] + row;
                int nc = dy[i] + col;
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && vis[nr][nc] == 0 && grid[nr][nc] == 0) {
                    q.add(new Pair(nr, nc, steps + 1));
                    vis[nr][nc] = 1;
                }
            }
        }
        return maxSteps < 1 ? -1 : maxSteps;
    }
}