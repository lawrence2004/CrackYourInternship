// package CrackYourInternship.Matrix;

class Solution {
    public void dfs(int row, int col, char[][] grid, int[][] vis, int n, int m) {
        vis[row][col] = 1;
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};
        for(int i = 0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && ncol >= 0 && ncol < m && nrow < n && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, grid, vis, n, m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0) {
                    cnt++;
                    dfs(i, j, grid, vis, n, m);
                }
            }
        }
        return cnt;
    }
}