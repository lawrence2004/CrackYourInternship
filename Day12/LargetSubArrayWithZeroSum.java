package CrackYourInternship.Day12;

import java.util.*;
class GfG
{
    int maxLen(int arr[], int n)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        for(int i = 0;i<n;i++) {
            prefixSum += arr[i];
            if(prefixSum == 0) maxLen = Math.max(maxLen, i + 1);
            int rem = prefixSum;
            if(mp.containsKey(rem)) {
                int len = i - mp.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if(!mp.containsKey(prefixSum)) mp.put(prefixSum, i);
        }
        return maxLen;
    }
}
