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
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        int pos = 1;
        ListNode temp = head;
        ListNode start = null;
        ListNode end = null;
        ListNode last = null;
        ListNode rem = null;
        while(temp != null) {
            if(pos == left) {
                start = temp;
            }
            else if(pos < left) last = temp;
            if(pos == right) {
                end = temp;
                rem = temp.next;
                break;
            }
            pos++;
            temp = temp.next;
        }
        end.next = null;
        ListNode neww = reverse(start);
        start.next = rem;
        if(last == null) return neww;
        last.next = neww;
        return head;
    }
}