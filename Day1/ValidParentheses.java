package CrackYourInternship.Strings;

import java.util.*;
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(st.isEmpty()) {
                if(ch == ')'  || ch == ']' || ch == '}') return false;
                else st.push(ch);
            }
            else {
                if(ch == '('  || ch == '[' || ch == '{') st.push(ch);
                else if(ch == ')') {
                    if(st.peek() =='(') st.pop();
                    else return false;
                }
                else if(ch == ']') {
                    if(st.peek() =='[') st.pop();
                    else return false;
                }
                else {
                    if(st.peek() =='{') st.pop();
                    else return false;
                }
            }
        }
        return true;
    }
}