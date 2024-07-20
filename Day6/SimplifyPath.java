package CrackYourInternship.Day6;

import java.util.*;
class Solution {
    public String simplifyPath(String s) {
        Deque<String> st = new LinkedList<>();
        int n = s.length();
        for(int i = 0;i<n;i++) {
            if(s.charAt(i) == '/') continue;
            int index = s.indexOf('/', i);
            String substr;
            if(index == -1) {
                substr = s.substring(i, n);
                i = n;
            }
            else {
                substr = s.substring(i, index);
                i = index;
            }
            if(substr.equals("..")) {
                if(!st.isEmpty()) {
                    st.pollLast();
                }
            }
            else if(!substr.equals(".")){
                st.offerLast(substr);
            }
        }
        if(st.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append("/");
            sb.append(st.pollFirst());
        }
        return sb.toString();
    }
}
