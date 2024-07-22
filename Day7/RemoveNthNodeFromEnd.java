package CrackYourInternship.Day7;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        if(n == 1) {
            if(head.next == null) return null;
        }
        ListNode fast = head;
        for(int i = 1;i<=n;i++) {
            fast = fast.next;
        }
        if(fast == null) {
            return head.next;
        }
        ListNode temp = head;
        while(fast.next != null) {
            fast = fast.next;
            temp = temp.next;
        }
        ListNode del = temp.next;
        temp.next = temp.next.next;
        del.next = null;
        return head;
    }
}
