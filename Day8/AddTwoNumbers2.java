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
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode last = null;
        while(temp != null) {
            ListNode curr = temp.next;
            temp.next = last;
            last = temp;
            temp = curr;
        }
        return last;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = reverse(l1);
        ListNode b = reverse(l2);
        ListNode t1 = a;
        ListNode t2 = b;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int sum = 0;
        int carry = 0;
        while(t1 != null || t2 != null) {
            sum = carry;
            if(t1 != null) sum += t1.val;
            if(t2 != null) sum += t2.val;
            ListNode x = new ListNode(sum % 10);
            carry = sum / 10;
            current.next = x;
            current = x;
            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }
        if(carry == 1) {
            ListNode x = new ListNode(carry);
            current.next = x;
            current = x;
        }
        ListNode ans = dummy.next;
        return reverse(ans);
    }
}
