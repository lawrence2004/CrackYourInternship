package CrackYourInternship.Day6;

/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        if(head == null || head.next == null) return head;
        Deque<Integer> dq = new ArrayDeque<>();
        Node temp = head;
        while(temp != null) {
            while(!dq.isEmpty() && dq.peekLast() < temp.data) {
                dq.pollLast();
            }
            dq.addLast(temp.data);
            temp = temp.next;
        }
        Node dummy = new Node(-1);
        Node current = dummy;
        while(!dq.isEmpty()) {
            Node x = new Node(dq.pollFirst());
            current.next = x;
            current = x;
        }
        return dummy.next;
    }
}
