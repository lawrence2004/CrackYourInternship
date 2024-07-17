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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode temp = head;
        ListNode last = null;
        while(temp != null) {
            if(temp.val == val) {
                if(last == null) {
                    head = head.next;
                    temp = temp.next;
                }
                else {
                    last.next = temp.next;
                    ListNode current = temp;
                    temp = temp.next;
                    current.next = null;
                }
            }
            else {
                last = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}
