class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start=1;
        int end=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;++i)
        {
            end=Math.max(end,nums[i]);
        }
        int result=end;
        while(start<end)
        {
            int mid=(start+end)/2;int count=0;
            //System.out.print(mid);
            for(int i=0;i<nums.length;++i)
            {
                if(nums[i]<mid){count+=1;}
                else{if(nums[i]%mid==0){count+=(nums[i]/mid);}
                else{count+=((nums[i]/mid)+1);}}
            }
            if(count>threshold){start=mid+1;}
            else{end=mid;result=mid;}
        }
        return result;
    }
}