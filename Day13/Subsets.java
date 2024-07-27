package CrackYourInternship.Day13;

import java.util.*;
class Solution {
    public void createSubSequences(int i,List<List<Integer>> li,List<Integer> temp,int[] nums) {
        if(i == nums.length) {
            li.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        createSubSequences(i+1,li,temp,nums);
        temp.remove(temp.size()-1);
        createSubSequences(i+1,li,temp,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        createSubSequences(0,li,temp,nums);
        return li;
    }
}
