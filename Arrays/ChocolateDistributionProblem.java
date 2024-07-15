import java.util.*;
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        long minDiff = Long.MAX_VALUE;
        for(int i = 0;i<=n - m;i++){
            minDiff = Math.min(minDiff, a.get(i + m - 1) - a.get(i));
        }
        return minDiff;
    }
}