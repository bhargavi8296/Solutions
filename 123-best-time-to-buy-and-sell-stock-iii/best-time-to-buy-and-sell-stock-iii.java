class Solution {
    int dp[][][];
    public int helper(int[]prices, int i, int s, int count)
    {
        if(count==0||i==prices.length){return 0;}
        if(dp[i][s][count]!=-1){return dp[i][s][count];}
        if(s==1)
        {
            return dp[i][s][count]=Math.max(helper(prices,i+1,0,count-1)+prices[i],helper(prices,i+1,s,count));
        }
        return dp[i][s][count]=Math.max(helper(prices,i+1,1,count)-prices[i],helper(prices,i+1,s,count));
    }
    public int maxProfit(int[] prices) {
        dp=new int[prices.length+1][3][3];
        for(int i=0;i<prices.length+1;++i)
        {
            for(int j=0;j<3;++j)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(prices,0,0,2);
    }
}