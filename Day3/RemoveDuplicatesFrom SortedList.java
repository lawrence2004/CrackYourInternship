package CrackYourInternship.LinkedList;
import java.util.*;
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head; 
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            if(st.isEmpty() || st.peek() != temp.val) st.push(temp.val);
            temp = temp.next;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while(!st.isEmpty()) {
            ListNode n = new ListNode(st.peek());
            current.next = n;
            current = n;
            st.pop();
        }
        return reverse(dummyNode.next);
    }
}
