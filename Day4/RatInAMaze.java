package CrackYourInternship.Day4;

import java.util.*;
class Solution {
    private static void ratMaze(int row, int col, int[][] grid, int[][] vis, ArrayList<String> ans,int[] delrow, int[] delcol, int n, StringBuilder sb) {
        if(row == n-1 && col == n-1) {
            ans.add(sb.toString());
            return;
        }
        for(int i = 0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                if(i == 0) sb.append("L");
                else if(i == 1) sb.append("U");
                else if(i == 2) sb.append("D");
                else if(i == 3) sb.append("R");
                vis[row][col] = 1;
                ratMaze(nrow, ncol, grid, vis, ans, delrow, delcol, n, sb);
                vis[row][col] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[][] vis = new int[n][n];
        int[] delrow = {0, -1, 1, 0};
        int[] delcol = {-1, 0, 0, 1};
        if(m[0][0]==1) ratMaze(0, 0, m, vis, ans, delrow, delcol, n, sb);
        if(ans.size() > 0) return ans;
        ans.add("-1");
        return ans;
    }
}
