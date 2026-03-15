class Solution {
    int dp[][];
    public int helper(int []nums,int target, int n)
    {
        //System.out.print(target+" "+n);
        if(target<0){return 0;}
        if(dp[n][target]!=-1){return dp[n][target];}
        if(n==0)
        {
            //System.out.println(n+" "+target);
            if(target==0||target==nums[n]){return dp[n][target]=nums[n]==0?2:1; }
            return dp[n][target]=0;
        }
        return dp[n][target]=helper(nums,target-nums[n],n-1)+helper(nums,target,n-1);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;++i)
        {
            sum+=nums[i];
        }
        if((sum+target)%2!=0){return 0;}
        sum=(sum+target)/2;
        if(sum<0){return 0;}
        dp=new int[nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        //System.out.print(sum+" "+dp[0].length);
        return helper(nums,sum,nums.length-1);
    }
}