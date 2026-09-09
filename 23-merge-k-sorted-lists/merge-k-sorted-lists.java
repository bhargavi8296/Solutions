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
    List<Integer>list;
    public void helper(int data)
    {
        list.add(data);
        int size=list.size()-1;
        while(size>0)
        {
            int par=(size-1)/2;
            if(list.get(par)>list.get(size))
            {
                int temp=list.get(par);
                list.set(par,list.get(size));
                list.set(size,temp);
            }
            else{break;}
            size=par;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        list=new ArrayList<>();
        for(int i=0;i<lists.length;++i)
        {
            ListNode temp=lists[i];
            while(temp!=null)
            {
                helper(temp.val);
                temp=temp.next;
            }
        }
        ListNode head=null;
        ListNode temp=null;
        System.out.println(list);
        int size=list.size();
        for(int i=0;i<size;++i)
        {
            // System.out.println(list);
            int tem=list.get(0);
            list.set(0,list.get(list.size()-1));
            list.set(list.size()-1,tem);
            //System.out.println(list.get(list.size()-1));
            ListNode t=new ListNode(list.get(list.size()-1));
            list.remove(list.size()-1);
            if(head==null){head=t;temp=t;}
            else{temp.next=t;temp=t;}
            int j=0;
            while(true)
            {
                int left=2*j+1;
                int right=2*j+2;
                int min=j;
                
                if(left>=list.size()){break;}
                if(list.get(left)<list.get(j))
                {
                    min=left;
                }
                if(right<list.size()&&list.get(right)<list.get(min))
                {
                    min=right;
                }
                //System.out.println(j+" "+left+" "+right+" "+list.get(left)+" "+list.get(right)+" "+min);
                if(min==j){break;}
                tem=list.get(min);
                list.set(min,list.get(j));
                list.set(j,tem);
                j=min;
            }
        }
        return head;
    }
}