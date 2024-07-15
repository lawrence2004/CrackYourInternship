class Solution {
    public boolean dfs(int row, int col, int n, int m, char[][] board, String word, int ind, int[][] vis) {
        if(ind == word.length()) {
            return true;
        }
        vis[row][col] = 1;
        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};
        for(int i = 0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == word.charAt(ind)) {
                if(dfs(nrow, ncol, n, m, board, word, ind + 1, vis) == true) {
                    return true;
                }
            }
        }
        vis[row][col] = 0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(board[i][j] == word.charAt(0)) {
                    vis[i][j] = 1;
                    if(dfs(i, j, n, m, board, word, 1, vis) == true) return true;
                }
            }
        }
        return false;
    }
}