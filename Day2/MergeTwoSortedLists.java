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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                current.next = temp1;
                current = temp1;
                temp1 = temp1.next;
            }
            else {
                current.next = temp2;
                current = temp2;
                temp2 = temp2.next;
            }
        }
        while(temp1 != null) {
            current.next = temp1;
            current = temp1;
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            current.next = temp2;
            current = temp2;
            temp2 = temp2.next;
        }
        return dummyNode.next;
    }
}