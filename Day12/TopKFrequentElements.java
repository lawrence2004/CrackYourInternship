package CrackYourInternship.Day12;

import java.util.*;
class Pair {
    int key, value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p2.value, p1.value);
            }
        });
        Arrays.sort(nums);
        int last = (int)1e5;
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            if(last == 1e5) {
                cnt = 1;
                last = nums[i];
            }
            else {
                if(last == nums[i]) {
                    cnt++;
                }
                else {
                    pq.add(new Pair(last, cnt));
                    last = nums[i];
                    cnt = 1;
                }
            }
        }
        pq.add(new Pair(last, cnt));
        int i = 0;
        int[] ans = new int[k];
        while(!pq.isEmpty()) {
            if(k > 0) {
                ans[i++] = pq.peek().key;
                pq.poll();
                k--;
            }
            else break;
        }
        return ans;
    }
}