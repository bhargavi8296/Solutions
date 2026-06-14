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
    public ListNode helper(ListNode head,ListNode prev)
    {
        if(head.next==null){head.next=prev;return head;}
        ListNode res=helper(head.next,head);
        head.next=prev;
        return res;
    }
    public int pairSum(ListNode head) {
        ListNode temp=head;
        ListNode temp1=null;
        ListNode first=null;
        while(temp!=null&&temp.next!=null)
        {
            temp=temp.next.next;
            if(temp1==null){temp1=head;first=temp1;}
            else{temp1=temp1.next;}
        }
        ListNode second=temp1.next;
        temp1.next=null;
        second=helper(second,null);
        int ans=0;
        while(first!=null)
        {
            ans=Math.max(ans,first.val+second.val);
            first=first.next;
            second=second.next;
        }
        return ans;

    }
}