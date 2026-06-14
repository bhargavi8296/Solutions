class Solution {
    int dp[];
    public int helper(int[]nums, int i,int n)
    {
        if(i>n){return 0;}
        if(dp[i]!=-1){return dp[i];}
        return dp[i]=Math.max(helper(nums,i+2,n)+nums[i],helper(nums,i+1,n));
    }
    public int rob(int[] nums) {
        if(nums.length==1){return nums[0];}
        dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int first=helper(nums,0,nums.length-2);
        Arrays.fill(dp,-1);
        int second=helper(nums,1,nums.length-1);
        return Math.max(first,second);
    }
}