package CrackYourInternship.LinkedList;

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
        ListNode last = null;
        ListNode temp = head;
        while(temp != null) {
            ListNode current = temp.next;
            temp.next = last;
            last = temp;
            temp = current;
        }
        return last;
    }
    public int getDecimalValue(ListNode head) {
        ListNode headd = reverse(head);
        int i = 0;
        ListNode temp = headd;
        int ans = 0;
        while(temp != null) {
            ans += Math.pow(2, i) * temp.val;
            i++;
            temp = temp.next;
        }
        return ans;
    }
}