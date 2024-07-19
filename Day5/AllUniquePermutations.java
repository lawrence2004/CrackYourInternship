package CrackYourInternship.Day5;

import java.util.*;
class Solution {
    public static void permutations(ArrayList<Integer> arr, HashSet<ArrayList<Integer>> ans, ArrayList<Integer> li, int n, boolean[] vis) {
        if(li.size() == n) {
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i = 0;i<n;i++) {
            if(!vis[i]) {
                vis[i] = true;
                li.add(arr.get(i));
                permutations(arr, ans, li, n, vis);
                vis[i] = false;
                li.remove(li.size() - 1);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        HashSet<ArrayList<Integer>> ans = new LinkedHashSet<>();
        Collections.sort(arr);
        boolean vis[] = new boolean[n];
        ArrayList<Integer> li = new ArrayList<>();
        permutations(arr, ans, li, n, vis);
        ArrayList<ArrayList<Integer>> a = new ArrayList<>(ans);
        return a;
    }
};
