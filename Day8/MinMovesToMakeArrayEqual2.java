package CrackYourInternship.Day8;

import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int mid = n / 2;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0;i<n;i++) {
            if(i != mid) {
                ans += Math.abs(nums[i] - nums[mid]);
            }
        }
        return ans;
    }
}
