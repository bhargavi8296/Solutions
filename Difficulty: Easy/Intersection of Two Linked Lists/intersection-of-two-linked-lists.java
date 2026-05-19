/* structure of list node:

class Node
{
    int data;
    Node next;
    Node(int val)
    {
        data=val;
        next=null;
    }
}

*/

class Solution {
    public Node findIntersection(Node head1, Node head2) {
        // code here
        HashSet<Integer> list = new HashSet<>();
        while(head2!=null)
        {
            list.add(head2.data);
            head2=head2.next;
        }
        Node start=null;
        Node result=null;
        while(head1!=null)
        {
            if(list.contains(head1.data))
            {
                Node temp=head1.next;
                if(result==null)
                {
                    start=head1;
                    result=start;
                }
                else
                {
                    start.next=head1;;
                    start=start.next;
                }
                start.next=null;
                head1=temp;
            }
            else{
                head1=head1.next;
            }
        }
        return result;
    }
}