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
    public void helper(int start, List<Integer>list, int size)
    {
    int smallest = start;
    int left = 2 * start + 1;
    int right = 2 * start + 2;

    if(left <= size && list.get(smallest) > list.get(left))
    {
        smallest = left;
    }
    if(right <= size && list.get(smallest) > list.get(right))
    {
        smallest = right;
    }

    if(smallest != start)
    {
        int t = list.get(start);
        list.set(start, list.get(smallest));
        list.set(smallest, t);

        helper(smallest, list, size);
    }

    }
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<lists.length;++i)
        {
            ListNode temp=lists[i];
            while(temp!=null)
            {
                list.add(temp.val);
                int ind=list.size()-1;
                while(ind>0)
                {
                    int par=(ind-1)/2;
                    if(list.get(par)>list.get(ind))
                    {
                        int t=list.get(ind);
                        list.set(ind,list.get(par));
                        list.set(par,t);
                    }
                    else{
                        break;
                    }
                    ind=(ind-1)/2;
                }
                temp=temp.next;
            }
        }
        ListNode head=null;
        ListNode temp=null;
        int size = list.size() - 1;

        while(size >= 0)
        {
            int val = list.get(0);

            // swap root with last
            int t = list.get(0);
            list.set(0, list.get(size));
            list.set(size, t);

            // reduce heap
            size--;

            // heapify
            helper(0, list, size);

            // build answer
            if(temp == null)
            {
                temp = new ListNode(val);
                head = temp;
            }
            else
            {
                temp.next = new ListNode(val);
                temp = temp.next;
            }
} 
        return head;
    }
}