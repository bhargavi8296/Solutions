class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){return nums[0];}
        int dp[]=new int[nums.length];
        dp[dp.length-1]=nums[nums.length-1];
        dp[dp.length-2]=Math.max(nums[nums.length-1],nums[nums.length-2]);
        for(int i=nums.length-3;i>=0;--i)
        {
            dp[i]=Math.max(nums[i]+dp[i+2],dp[i+1]);
        }
        return Math.max(dp[0],dp[1]);
    }
}