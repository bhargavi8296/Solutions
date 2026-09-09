class Solution {
    public void helper(int []heap, int i)
    {
        while(i>0)
        {
            //System.out.println(i+" "+heap[i]);
            int par=(i-1)/2;
            if(heap[par]<heap[i])
            {
                int temp=heap[par];
                heap[par]=heap[i];
                heap[i]=temp;
            }
            else{
                break;
            }
            i=par;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        int heap[]=new int[nums.length];
        for(int i=0;i<nums.length;++i)
        {
            heap[i]=nums[i];
            helper(heap,i);
        }
        // for(int i=0;i<nums.length;++i)
        // {
        //     System.out.println(heap[i]);
        // }
        int size=nums.length-1;
        for(int i=0;i<k-1;++i)
        {
            //System.out.println(i);
            int temp=heap[0];
            heap[0]=heap[size];
            heap[size]=temp;
            --size;
            int j=0;
            while(true)
            {
                
                int left=2*j+1;
                int right=2*j+2;
                int max=j;
                if(left>size){break;}
                if(heap[left]>heap[max])
                {max=left;}
                if(right<=size&&heap[right]>heap[max]){max=right;}
                //System.out.println();
                if(max==j){break;}
                temp=heap[j];
                heap[j]=heap[max];
                heap[max]=temp;
                j=max;
                
                
            }

        }
        return heap[0];
    }
}