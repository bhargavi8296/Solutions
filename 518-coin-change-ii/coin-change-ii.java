class Solution {
    int dp[][];
    public int helper(int amount, int[]coins,int i)
    {
        if(amount==0){return 1;}
        if(i<0){return 0;}
        if(dp[i][amount]!=-1){return dp[i][amount];}
        if(coins[i]<=amount)
        {
            return dp[i][amount]= helper(amount-coins[i],coins,i)+helper(amount,coins,i-1);
        }
        return dp[i][amount]=helper(amount,coins, i-1);
    }
    public int change(int amount, int[] coins) {
        dp=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(amount, coins, coins.length-1);
    }
}