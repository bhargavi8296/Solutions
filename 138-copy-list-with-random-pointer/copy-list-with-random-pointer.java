/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){return null;}
        Node root=new Node(head.val);
        Map<Node,Node>map=new HashMap<>();
        Node temp=root;
        map.put(head,root);
        Node t=head.next;
        while(t!=null)
        {
            temp.next=new Node(t.val);
            map.put(t,temp.next);
            t=t.next;
            temp=temp.next;
        }
        t=head;
        temp=root;
        while(t!=null)
        {
            temp.random=map.getOrDefault(t.random,null);
            t=t.next;
            temp=temp.next;
        }
        return root;
    }
}