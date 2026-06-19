class Solution {
    int dp[][];
    public int helper(int[]prices, int i, int s)
    {
        if(i==prices.length){return 0;}
        if(dp[i][s]!=-1){return dp[i][s];}
        if(s==1)
        {
            return dp[i][s]=Math.max(helper(prices,i+1,0)+prices[i],helper(prices,i+1,s));
        }
        return dp[i][s]=Math.max(helper(prices,i+1,1)-prices[i],helper(prices,i+1,s));
    }
    public int maxProfit(int[] prices) {
        dp=new int[prices.length+1][3];
        for(int i=0;i<prices.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(prices,0,0);
    }
}