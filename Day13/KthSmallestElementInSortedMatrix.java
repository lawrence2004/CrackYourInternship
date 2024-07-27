package CrackYourInternship.Day13;

import java.util.*;
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                pq.add(matrix[i][j]);
            }
        }
        int smallest = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            if(k > 0) {
                smallest = pq.poll();
                k--;
            }
            else break;
        }
        return smallest;
    }
}
