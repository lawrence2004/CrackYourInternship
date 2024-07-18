package CrackYourInternship.Day4;

import java.util.*;
class Pair {
    int row, col, steps;
    Pair(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[N][N];
        vis[KnightPos[0] - 1][KnightPos[1] - 1] = 1;
        q.offer(new Pair(KnightPos[0] - 1, KnightPos[1] - 1, 0));
        
        int delrow[] = {-1, -2, -2, -1, +1, +2, +2, +1};
        int delcol[] = {-2, -1, +1, +2, +2, +1, -1, -2};
        
        while(!q.isEmpty()) {
            Pair it = q.peek();
            int row = it.row;
            int col = it.col;
            int steps = it.steps;
            q.poll();
            
            if(row == TargetPos[0] - 1 && col == TargetPos[1] - 1) return steps;
            
            for(int i = 0;i<8;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                
                if(nrow >= 0 && ncol >= 0 && nrow < N && ncol < N && vis[nrow][ncol] == 0) {
                    q.offer(new Pair(nrow, ncol, steps + 1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        
        return -1;
    }
}
