class Solution {
    int dp[][];
    public int helper(int[]nums, int ind, int prev)
    {
        if(ind==nums.length){return 0;}
        if(dp[ind][prev+1]!=-1){return dp[ind][prev+1];}
        int not_take=helper(nums,ind+1,prev);
        int take=0;
        if(prev==-1||nums[prev]<nums[ind])
        {
            take=1+helper(nums,ind+1,ind);
        }
        return dp[ind][prev+1]=Math.max(take,not_take);
    }
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,0,-1);
    }
}