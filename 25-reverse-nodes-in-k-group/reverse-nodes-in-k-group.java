/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode top=null;
    public ListNode helper(ListNode node,ListNode prev)
    {
        if(node.next==null)
        {
            //System.out.println(node.val);
            if(top==null){
                top=node;}
            node.next=prev;
            return node;
        }
        //System.out.println(node.val);
        ListNode temp=helper(node.next,node);
        node.next=prev;
        //System.out.println(temp.val+" "+prev);
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){return head;}
        ListNode kk=head;
        int count=0;
        while(kk!=null){++count;kk=kk.next;}
        if(count<k){return head;}
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            int tk=k;
            ListNode next=temp;
            ListNode t=temp;
            while(t.next!=null&&tk-1>0)
            {
                t=t.next;
                tk-=1;
            }
            if(tk>1){prev.next=next;break;}
            temp=t.next;
            t.next=null;
            if(prev!=null){prev.next=helper(next,null);}
            else{
                helper(next,null);
            }
            prev=next;
        }
        return top;
    }
}