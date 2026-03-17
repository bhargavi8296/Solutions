class Solution {
    int dp[][];
    public int helper(int prices[],int j,int s)
    {
        if(j==prices.length){return 0;}
        if(dp[j][s]!=-1){return dp[j][s];}
        //System.out.print(j+" "+s);
        if(s==1)
        {
            return dp[j][s]=Math.max(prices[j]+helper(prices,j+1,0),helper(prices,j+1,s));
        }
        return dp[j][s]=Math.max(helper(prices,j+1,1)-prices[j],helper(prices,j+1,s));
    }
    public int maxProfit(int[] prices) {
        dp=new int[prices.length+1][2];
        for(int i=0;i<prices.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(prices,0,0);
    }
}