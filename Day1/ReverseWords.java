package CrackYourInternship.Strings;
import java.util.*;
class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        int n = s.length();
        for(int i = 0;i<n;i++) {
            if(s.charAt(i) != ' ') {
               int index = s.indexOf(' ',i);
               if(index == -1) {
                  st.push(s.substring(i,n));
                  break;
               }
               else {
                  st.push(s.substring(i,index));
                  i = index;
               }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop()).append(" ");
        }
        return sb.toString().trim();
    }
}
