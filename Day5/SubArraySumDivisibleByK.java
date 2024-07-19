import java.util.*;;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mp =new HashMap<>();
        mp.put(0, 1);
        int prefixSum = 0;
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            prefixSum += nums[i];
            int mod = prefixSum % k;
            if(mod < 0) mod += k;
            if(mp.containsKey(mod)) {
                cnt += mp.get(mod);
            }
            mp.put(mod,mp.getOrDefault(mod, 0) + 1);
        }
        return cnt;
    }
}