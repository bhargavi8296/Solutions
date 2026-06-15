class Solution {
    int dp[][];
    int[]c;
    public int helper( int amount, int i)
    {
        if(amount==0){return 0;}
        //System.out.print(amount+" ");
        if(i<0){return 10001;}
        if(dp[i][amount]!=-1){return dp[i][amount];}
        if(c[i]<=amount)
        {
            return dp[i][amount]=Math.min(helper(amount-c[i],i)+1,helper(amount,i-1));
        }
        return dp[i][amount]=helper(amount,i-1);
    }
    public int coinChange(int[] coins, int amount) {
        dp=new int[coins.length+1][amount+1];
        c=coins;
        for(int i=0;i<coins.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        int result=helper(amount,coins.length-1);
        return result>10000?-1:result;
    }
}