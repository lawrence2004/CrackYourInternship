package CrackYourInternship.Day9;

import java.util.*;
class Pair {
    String str;
    int steps;
    Pair(String str, int steps) {
        this.str = str;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()) {
            Pair it = q.poll();
            String word = it.str;
            int steps = it.steps;
            if(word.equals(endWord)) return steps;
            for(int i = 0;i<word.length();i++) {
                for(char ch = 'a';ch<='z';ch++) {
                    char[] wordArr = word.toCharArray();
                    wordArr[i] = ch;
                    String replacedCharArray = new String(wordArr);
                    if(st.contains(replacedCharArray)) {
                        q.add(new Pair(replacedCharArray, steps + 1));
                        st.remove(replacedCharArray);
                    }
                }
            }
        }
        return 0;
    }
}
