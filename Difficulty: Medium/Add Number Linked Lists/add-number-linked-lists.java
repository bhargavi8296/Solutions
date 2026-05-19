/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node h,Node prev)
    {
        if(h.next==null)
        {
            h.next=prev;
            return h;
        }
        Node temp=reverse(h.next,h);
        h.next=prev;
        return temp;
        
    }
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        head1=reverse(head1,null);
        head2=reverse(head2,null);
        int carry=0;
        Node result=null;
        Node temp=null;
        while(head1!=null&&head2!=null)
        {
            int sum=(head1.data+head2.data+carry)%10;
            carry=(head1.data+head2.data+carry)/10;
            if(result==null)
            {
                result=new Node(sum);
                temp=result;
            }
            else{
                temp.next=new Node(sum);
                temp=temp.next;
            }
            head1=head1.next;
            head2=head2.next;
        }
        while(head1!=null)
        {
            int sum=(head1.data+carry)%10;
            carry=(head1.data+carry)/10;
            temp.next=new Node(sum);
            temp=temp.next;
            head1=head1.next;
            
        }
        while(head2!=null)
        {
            int sum=(head2.data+carry)%10;
            carry=(head2.data+carry)/10;
            temp.next=new Node(sum);
            temp=temp.next;
            head2=head2.next;
        }
        if(carry!=0)
        {
            temp.next=new Node(carry);
            temp=temp.next;
        }
        result=reverse(result,null);
        while(result!=null&&result.data==0){result=result.next;}
        return result;
    }
}