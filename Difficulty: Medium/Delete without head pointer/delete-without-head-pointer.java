/* Structure of linked list Node
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/
class Solution {
    public void deleteNode(Node del_node) {
        // code here
        while(del_node.next!=null)
        {
            int temp=del_node.data;
            del_node.data=del_node.next.data;
            del_node.next.data=temp;
            if(del_node.next.next==null)
            {
                del_node.next=null;
            }
            else{
                del_node=del_node.next;
            }
            
        }
    }
}