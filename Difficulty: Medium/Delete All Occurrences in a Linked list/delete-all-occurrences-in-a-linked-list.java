/* Structure of a linked list node
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}
*/
class Solution {
    public Node helper(Node head, int x)
    {
        if(head==null){return null;}
        if(head.data==x)
        {
            return helper(head.next,x);
        }
        head.next=helper(head.next,x);
        return head;
    }
    public Node deleteAllOccurances(Node head, int x) {
        // code here
        
        return helper(head,x);
    }
}