/* Structure of linked list Node
class Node
{
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    int getKthFromLast(Node head, int k) {
        // code here
        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            ++count;
        }
        if(k>count){return -1;}
        count=count-k;
        while(count>0)
        {
            head=head.next;
            --count;
        }
        return head.data;
    }
}