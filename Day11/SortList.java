package CrackYourInternship.Day11;

class Solution {
    public ListNode merge(ListNode t1, ListNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        ListNode head = null;
        ListNode tail = null;
        if(t1.val <= t2.val) {
            head = tail = t1;
            t1 = t1.next;
        }
        else {
            head = tail = t2;
            t2 = t2.next;
        }
        while(t1 != null && t2 != null) {
            if(t1.val <= t2.val) {
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            }
            else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }
        if(t1 != null) tail.next = t1;
        else tail.next = t2;
        return head;
    }
    public ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = mid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = sortList(left);
        right = sortList(right);
        ListNode ans = merge(left, right);
        return ans;
    }
}
