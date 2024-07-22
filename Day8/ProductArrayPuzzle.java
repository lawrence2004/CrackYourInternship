package CrackYourInternship.Day8;

class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{
        int cnt = 0;
        long prod = 1;
        for(int it : nums) {
            if(it != 0) prod *= it;
            else cnt++;
        }
        long[] ans = new long[n];
        for(int i = 0;i<n;i++) {
            if(cnt == 1) {
                if(nums[i] == 0) ans[i] = prod;
                else ans[i] = 0;
            }
            else if(cnt >= 2) ans[i] = 0;
            else ans[i] = prod / nums[i];
        }
        return ans;
	} 
} 
