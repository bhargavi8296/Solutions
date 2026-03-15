class Solution {
    int dp[][];
    public int helper(int[]coins, int amount, int n)
    {
        //System.out.println(amount+" "+n);
        if(amount==0){return 0;}
        if(amount<0||n<0){return 10001;}
        if(dp[n][amount]!=-1){return dp[n][amount];}
        if(coins[n]<=amount)
        {
            dp[n][amount]=Math.min(helper(coins,amount-coins[n],n)+1,helper(coins,amount,n-1));
            return dp[n][amount];
        }
        return dp[n][amount]=helper(coins,amount,n-1);
    }
    public int coinChange(int[] coins, int amount) {
        dp=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        int temp=helper(coins,amount,coins.length-1);
        return temp>=10001?-1:temp;
    }
}