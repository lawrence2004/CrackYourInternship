package CrackYourInternship.Day11;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        Deque<Integer> dq = new LinkedList<>();
        ListNode temp = head;
        int last = Integer.MIN_VALUE;
        while(temp != null) {
            if((dq.isEmpty() || temp.val != dq.peekLast()) && last != temp.val) {
                last = temp.val;
                dq.offerLast(temp.val);
            }
            else if(!dq.isEmpty() && last == dq.peekLast())dq.pollLast();
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!dq.isEmpty()) {
            ListNode x = new ListNode(dq.pollFirst());
            curr.next = x;
            curr = x;
        }
        return dummy.next;
    }
}