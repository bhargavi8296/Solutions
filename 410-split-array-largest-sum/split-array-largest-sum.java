class Solution {
    public int helper(int[]nums, int k)
    {
        int n=0;
        int sum=0;
        for(int val:nums)
        {
            if(sum>=val){sum-=val;}
            else{sum=k-val;++n;}
        }
        return n;
    }
    public int splitArray(int[] nums, int k) {
        int start=1;
        int end=0;
        for(int val:nums){
            start=Math.max(start,val);
            end+=val;
        }
        int result=end;
        while(start<=end)
        {
            int mid=(start+end)/2;
            int n=helper(nums,mid);
            if(n<=k){result=Math.min(result,mid);end=mid-1;}
            else{start=mid+1;}
        }
        return result;
    }
}