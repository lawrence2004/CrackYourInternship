package CrackYourInternship.Strings;

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(n < m) return -1;
        int i = 0;
        int j = m;
        while(j < n) {
            String sub = haystack.substring(i, j);
            if(sub.equals(needle)) return i;
            i++;  j++;
        }
        if(haystack.substring(i, j).equals(needle)) return i;
        return -1;
    }
}
