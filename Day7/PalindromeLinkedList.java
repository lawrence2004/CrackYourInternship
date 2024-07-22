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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode sfast = reverse(slow.next);
        slow.next = null;
        slow = head;
        while(sfast != null) {
            if(slow.val != sfast.val) return false;
            slow = slow.next;
            sfast = sfast.next;
        }
        return true;
    }
}
