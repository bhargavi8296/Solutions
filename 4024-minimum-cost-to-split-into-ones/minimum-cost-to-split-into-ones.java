class Solution {
    int[]dp;
    public int helper(int n)
    {
        if(n==1){return 0;}
        if(dp[n]!=-1){return dp[n];}
        int result=Integer.MAX_VALUE;
        for(int i=1;i<=n/2;++i)
        {
            result=Math.min(result,(i*(n-i))+helper(i)+helper(n-i));
        }
        return dp[n]=result;
    }
    public int minCost(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
}