package CrackYourInternship.Day11;

import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int it : nums2) {
            while(!st.isEmpty() && it > st.peek()) {
                mp.put(st.pop(), it);
            }
            st.push(it);
        }
        int[] ans = new int[n];
        for(int i = 0;i<n;i++) {
            ans[i] = mp.getOrDefault(nums1[i], -1);
        } 
        return ans;
    }
}