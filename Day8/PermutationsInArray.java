package CrackYourInternship.Day8;

import java.util.*;
class Solution {
    public boolean isPossible(long a[], long b[], int n, long k) {
        Arrays.sort(a);
        Long[] x = Arrays.stream(b).boxed().toArray(Long[]::new);
        Arrays.sort(x, Collections.reverseOrder());
        for(int i = 0;i<n;i++) {
            if(a[i] + x[i] < k) return false;
        }
        return true;
    }
}