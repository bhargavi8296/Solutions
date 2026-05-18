/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node mergeKLists(Node[] arr) {
        // code here
        Node head=arr[0];
        for(int i=1;i<arr.length;++i)
        {
            Node newH=null;
            Node start=null;
            Node temp=arr[i];
            while(temp!=null&&head!=null)
            {
                if(temp.data<=head.data)
                {
                    Node next=temp.next;
                    if(newH==null)
                    {
                        newH=temp;
                        start=newH;
                        temp=next;
                    }
                    else{
                        newH.next=temp;
                        newH=newH.next;
                    }
                    temp=next;
                }
                else{
                    Node next=head.next;
                    if(newH==null)
                    {
                        newH=head;
                        start=newH;
                    }
                    else{
                        newH.next=head;
                        newH=newH.next;
                    }
                    head=next;
                }
            }
            if(head!=null)
            {
                newH.next=head;
            }
            if(temp!=null)
            {
                newH.next=temp;
            }
            head=start;
        }
        return head;
    }
}