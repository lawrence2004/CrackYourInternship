package CrackYourInternship.Day8;

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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode lessHead = new ListNode(-1);
        ListNode moreHead = new ListNode(-1);
        ListNode less = lessHead;
        ListNode more = moreHead;
        while(head != null) {
            if(head.val < x) {
                less.next = head;
                less = head;
            }
            else {
                more.next = head;
                more = head;
            }
            head = head.next;
        }
        less.next = moreHead.next;
        more.next = null;
        return lessHead.next;
    }
}
