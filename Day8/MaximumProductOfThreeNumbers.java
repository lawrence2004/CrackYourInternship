package CrackYourInternship.Day8;

import java.util.*;
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int first = nums[0] * nums[1] * nums[n-1];
        int last = nums[n-1] * nums[n-2] * nums[n-3];
        return Math.max(first, last);
    }
}
