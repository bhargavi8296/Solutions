class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int h=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;++i)
        {
            l=Math.min(l,nums[i]);
            h=Math.max(h,nums[i]);
        }
        int ans=h;
        while(l<=h)
        {
            int mid=(l+h)/2;
            int sum=0;
            for(int i=0;i<nums.length;++i)
            {
                sum+=(nums[i]%mid==0?nums[i]/mid:(nums[i]/mid)+1);
            }
            //System.out.println(mid+" "+sum+" "+l+" "+h);
            if(sum>threshold){l=mid+1;}
            else{ans=mid;h=mid-1;}
        }
        return ans;
    }
}