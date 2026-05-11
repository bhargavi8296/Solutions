class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ar1[]=new int[nums.length];
        int ar2[]=new int[nums.length];
        Arrays.fill(ar1,1);
        Arrays.fill(ar2,1);
        int max=1;
        for(int i=1;i<nums.length;++i)
        {
            if(nums[i]>nums[i-1]){ar1[i]+=ar1[i-1];max=Math.max(max,ar1[i]);}
        }
        for(int i=nums.length-2;i>=0;--i)
        {
            if(nums[i]>nums[i+1]){ar2[i]+=ar2[i+1];max=Math.max(max,ar2[i]);}
        }
        return max;
    }
}