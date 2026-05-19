/*
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        Map<Node,Node>map=new HashMap<>();
        Node result=null;
        Node start=null;
        Node temp=head;
        while(temp!=null)
        {
            Node t1=new Node(temp.data);
            if(result==null)
            {
                start=t1;
                result=start;
            }
            else
            {
                start.next=t1;
                start=start.next;
            }
            map.put(temp,t1);
            temp=temp.next;
        }
        temp=head;
        start=result;
        while(temp!=null)
        {
            //System.out.println(temp.data+" "+temp.random+" "+start.data+" "+start.random);
            start.random=map.getOrDefault(temp.random,null);
            start=start.next;
            temp=temp.next;
        }
        return result;
        
    }
}