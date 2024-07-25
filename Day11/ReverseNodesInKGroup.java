package CrackYourInternship.Day11;

class Solution {
    public ListNode reverse(ListNode head) {
        if(head == null || head.next ==null) return head;
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
    public void group(ListNode prev, ListNode head, int k) {
        int x = k - 1;
        ListNode temp = head;
        while(temp != null && x-- > 0) {
            temp = temp.next;
        }
        if(temp == null) return;
        if(prev != null) prev.next = null;
        ListNode front = temp.next;
        temp.next = null;
        ListNode rev = reverse(head);
        if(prev != null) prev.next = rev;
        head.next = front;
        group(head, front, k);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int x = k - 1;
        ListNode temp = head;
        while(temp != null && x-- > 0) {
            temp = temp.next;
        }
        group(null, head, k);
        return temp;
    }
}
