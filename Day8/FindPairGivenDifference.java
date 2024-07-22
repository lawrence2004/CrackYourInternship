package CrackYourInternship.Day8;

import java.util.*;
class Solution {
    public int findPair(int n, int x, int[] arr) {
        Set<Integer> st = new HashSet<>();
        for(int it : arr) {
            if(it < x) {
                if(st.contains(it + x)) return 1;
            }
            else if(it > x) {
                if(st.contains(it - x) || st.contains(it + x)) return 1;
            }
            st.add(it);
        }
        return -1;
    }
}
