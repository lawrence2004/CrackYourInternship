import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int preSum = 0;
        for(int i = 0;i<n;i++) {
            preSum += nums[i];
            int rem = preSum - k;
            if(mp.containsKey(rem)) {
                cnt += mp.get(rem);
            }
            mp.put(preSum, mp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}