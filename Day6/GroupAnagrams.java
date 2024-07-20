package CrackYourInternship.Day6;

import java.util.*;
class Solution {
    public String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String it : strs) {
            String word = sort(it);
            if(mp.containsKey(word)) {
                mp.get(word).add(it);
            }
            else {
                mp.put(word, new ArrayList<>());
                mp.get(word).add(it);
            }
        }
        return new ArrayList<>(mp.values());
    }
}
