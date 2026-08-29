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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){return head;}
        int total=0;
        ListNode temp=head;
        while(temp!=null)
        {
            temp=temp.next;++total;
        }
        k=k%total;
        if(total==k||k==0){return head;}
        k=total-k;
        int i=0;
        temp=head;
        ListNode result=temp;
        while(i+1<k)
        {
            temp=temp.next;
            ++i;
        }
        ListNode r=temp.next;
        temp.next=null;
        temp=r;
        while(temp.next!=null){temp=temp.next;}
        temp.next=result;
        return r;

    }
}