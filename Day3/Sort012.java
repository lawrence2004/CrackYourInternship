package CrackYourInternship.LinkedList;

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if(head == null || head.next == null) return head;
        // add your code here
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;
        while(temp != null) {
            if(temp.data == 0) {
                Node current = new Node(temp.data);
                zero.next = current;
                zero = current;
            }
            else if(temp.data == 1) {
                Node current = new Node(temp.data);
                one.next = current;
                one = current;
            }
            else {
                Node current = new Node(temp.data);
                two.next = current;
                two = current;
            }
            temp = temp.next;
        }
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        return zeroHead.next;
    }
}
