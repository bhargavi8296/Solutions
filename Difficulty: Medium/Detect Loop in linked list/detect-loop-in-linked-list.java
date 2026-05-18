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
    public boolean detectLoop(Node head) {
        // code here
        Node t1=head;
        Node t2=head;
        while(t1!=null&&t1.next!=null)
        {
            t1=t1.next.next;
            t2=t2.next;
            if(t1==t2){return true;}
        }
        return false;
    }
}