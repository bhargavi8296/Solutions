/* Structure of linked list Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */
class Solution {
    public static void removeLoop(Node head) {
        // code here
        Node t1=head;
        boolean loop=false;
        Node t2=head;
        while(t1!=null&&t1.next!=null)
        {
            t1=t1.next.next;
            t2=t2.next;
            if(t1==t2){loop=true;break;}
        }
        if(!loop){return ;}
        t1=head;
        if(t2==t1)
        {
            while(t2.next!=t1)
            {
                t2=t2.next;
            }
            t2.next=null;
            return;
        }
        while(t1.next!=t2.next)
        {
            t1=t1.next;
            t2=t2.next;
        }
        t2.next=null;
        
    }
}