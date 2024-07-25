package CrackYourInternship.Day11;

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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode rev = reverse(mid);
        ListNode first = head;
        ListNode second = rev;
        while(second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }
}
