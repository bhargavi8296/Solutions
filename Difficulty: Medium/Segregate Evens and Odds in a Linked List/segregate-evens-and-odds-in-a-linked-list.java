/* Structure of a link list node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    Node divide(Node head) {
        // code here
        Node even=null;
        Node odd=null;
        Node le=null;
        Node lo=null;
        while(head!=null)
        {
            Node temp=head.next;
            if(head.data%2==0)
            {
                if(even==null)
                {
                    even=head;
                    even.next=null;
                    le=even;
                    //System.out.print(even.data);
                }
                else
                {
                    le.next=head;
                    le=le.next;
                    le.next=null;
                }
            }
            else
            {
                if(odd==null)
                {
                    odd=head;
                    odd.next=null;
                    lo=odd;
                }
                else
                {
                    lo.next=head;
                    lo=lo.next;
                    lo.next=null;
                }
            }
            head=temp;
        }
        if(even==null){return odd;}
        le.next=odd;
        return even;
    }
}