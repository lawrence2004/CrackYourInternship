package CrackYourInternship.Day4;

class Solution {
    public void dfs(int row, int col, int[][] image, int color, int initColor, int[][] vis, int n, int m) {
        vis[row][col] = 1;
        image[row][col] = color;
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};
        for(int i = 0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && image[nrow][ncol] == initColor && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, image, color, initColor, vis, n, m);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] vis = new int[n][m];
        int initColor = image[sr][sc];
        dfs(sr, sc, image, color, initColor, vis, n, m);
        return image;
    }
}
