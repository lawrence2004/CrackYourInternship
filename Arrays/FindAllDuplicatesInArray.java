import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> li = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            int val = Math.abs(nums[i]);
            if(nums[val - 1] < 0) li.add(val);
            nums[val - 1] *= -1;
        }
        return li;
    }
}