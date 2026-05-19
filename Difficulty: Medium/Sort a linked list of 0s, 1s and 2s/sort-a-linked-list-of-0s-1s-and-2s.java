/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    Node head;
    public Node segregate(Node head) {
        // code here
        Node zero=null;
        Node ze=null;
        Node first=null;
        Node fe=null;
        Node second=null;
        while(head!=null)
        {
            Node temp=head.next;
            if(head.data==0)
            {
               if(zero==null)
               {
                   zero=head;
                   ze=zero;
                   zero.next=null;
               }
               else
               {
                   head.next=zero;
                   zero=head;
               }
               
            }
            else if(head.data==1)
            {
                if(first==null)
               {
                   first=head;
                   fe=first;
                    first.next=null;
               }
               else
               {
                   head.next=first;
                   first=head;
               }
            }
            else{
                if(second==null)
               {
                   second=head;
                    second.next=null;
               }
               else
               {
                   head.next=second;
                   second=head;
               }
            }
            head=temp;
        }
        if(fe==null){first=second;}
        else{
            fe.next=second;
        }
        if(ze==null){zero=first;}
        else{
            ze.next=first;
        }
        return zero;
        
    }
}
//head=>0 or 1 and 2 mein divide
