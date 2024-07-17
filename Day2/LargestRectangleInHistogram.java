import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ls = new int[n];
        int[] rs = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) ls[i] = 0;
            else ls[i] = st.peek() + 1;
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        for(int i = n-1;i>=0;i--) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if(st.isEmpty()) rs[i] = n-1;
            else rs[i] = st.peek() - 1;
            st.push(i);
        }
        int maxArea = 0;
        for(int i = 0;i<n;i++) {
            int val = (rs[i] - ls[i] + 1) * heights[i];
            maxArea = Math.max(maxArea, val);
        }
        return maxArea;
    }
}