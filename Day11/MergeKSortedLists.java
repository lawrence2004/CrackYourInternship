package CrackYourInternship.Day11;

class Solution {
    public ListNode merge(ListNode a, ListNode b) {
        if(a == null) return b;
        if(b == null) return a;
        ListNode head = null, tail = null;
        if(a.val <= b.val) {
            head = tail = a;
            a = a.next;
        }
        else {
            head = tail = b;
            b = b.next;
        }
        while(a != null && b != null) {
            if(a.val <= b.val) {
                tail.next = a;
                tail = a;
                a = a.next;
            }
            else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        if(a == null) tail.next = b;
        else tail.next = a;
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode ans = null;
        for(int i = 0;i<n;i++) {
            ans = merge(ans, lists[i]);
        }
        return ans;
    }
}
