class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0] == 0) return false;
        int n = nums.length;
        int maxInd = 0;
        for(int i = 0;i<n;i++) {
            if(i > maxInd) return false;
            maxInd = Math.max(maxInd, i + nums[i]);
        }
        return true;
    }
}