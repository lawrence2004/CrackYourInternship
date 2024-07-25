package CrackYourInternship.Day11;

import java.util.*;
class Solution
{
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st = new Stack<>();
        for(char ch : S.toCharArray()) {
            if(ch != '+' && ch != '-' && ch != '*' && ch != '/') st.push(ch - '0');
            else if(ch == '+') {
                int first = st.pop();
                int second = st.pop();
                st.push(first + second);
            }
            else if(ch == '-') {
                int first = st.pop();
                int second = st.pop();
                st.push(second - first);
            }
            else if(ch == '*') {
                int first = st.pop();
                int second = st.pop();
                st.push(first * second);
            }
            else if(ch == '/') {
                int first = st.pop();
                int second = st.pop();
                st.push(second / first);
            }
        }
        return st.pop();
    }
}
