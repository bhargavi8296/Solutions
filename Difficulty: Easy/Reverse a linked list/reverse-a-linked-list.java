/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node newH;
    Node helper(Node head,Node prev)
    {
        if(head.next==null)
        {
            newH=head;
            return head;
        }
        Node temp=helper(head.next,head);
        temp.next=head;
        head.next=null;
        return head;
        
    }
    Node reverseList(Node head) {
        // code here
        helper(head,null);
        return newH;
    }
}