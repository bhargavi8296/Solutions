/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node helper(Node head, Node prev)
    {
        if(head.next==null){head.next=prev;return head;}
        Node temp=helper(head.next,head);
        head.next=prev;
        return temp;
    }
    public boolean isPalindrome(Node head) {
        if(head==null||head.next==null){return true;}
        // code here
        Node t1=head;
        Node t2=null;
        Node first=null;
        while(t1!=null&&t1.next!=null)
        {
            t1=t1.next.next;
            if(t2==null)
            {
                t2=head;
                first=t2;
            }
            else{
                t2=t2.next;
            }
        }
        t1=t2.next;
        t2.next=null;
        t1=helper(t1,null);
        while(t1!=null&&first!=null)
        {
            //System.out.println(t1.data+" "+first.data);
            if(t1.data!=first.data){return false;}
            t1=t1.next;
            first=first.next;
        }
        return true;
    }
}