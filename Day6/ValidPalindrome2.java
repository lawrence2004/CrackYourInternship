package CrackYourInternship.Day6;

class Solution {
    public boolean palindrome(String s, int l, int r) {
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return palindrome(s, l + 1, r) || palindrome(s, l, r - 1);
            }
            else {
                l++;  r--;
            }
        }
        return true;
    }
}
