class Solution {
    int dp[][];
    public boolean helper(int[] nums,int ind, int sum)
    {
        if(sum==0){return true;}
        if(sum<0||ind<0){return false;}
        if(dp[ind][sum]!=-1){return dp[ind][sum]==0?false:true;}
        boolean flag=helper(nums,ind-1,sum-nums[ind])|helper(nums,ind-1,sum);
        dp[ind][sum]=flag==true?1:0;
        return flag;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;++i){sum+=nums[i];}
        if(sum%2==1){return false;}
        sum/=2;
        dp=new int[nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;++i){Arrays.fill(dp[i],-1);}
        return helper(nums,nums.length-1,sum);
    }
}