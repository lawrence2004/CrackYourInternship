package CrackYourInternship.Day12;

import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int it : nums) {
            pq.add(it);
        }
        if(k == 1) return pq.poll();
        int ans = 0;
        while(!pq.isEmpty()) {
            if(k > 1) {
                pq.poll();
                k--;
            }
            else {
                ans = pq.poll();
                break;
            }
        }
        return ans;
    }
}
