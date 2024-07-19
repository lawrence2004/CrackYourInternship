package CrackYourInternship.Day5;

class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int cnt1 = 0;
                for(int k = 0;k<8;k++) {
                    int nrow = i + dx[k];
                    int ncol = j + dy[k];
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && Math.abs(board[nrow][ncol]) == 1) {
                        cnt1++;
                    }
                }
                if(board[i][j] == 1 && (cnt1 < 2 || cnt1 > 3)) {
                    board[i][j] = -1;
                }
                if(board[i][j] == 0 && cnt1 == 3) {
                    board[i][j] = 2; 
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}