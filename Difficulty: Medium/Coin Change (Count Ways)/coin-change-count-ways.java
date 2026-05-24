class Solution {
    int dp[][];
    public int helper(int coins[],int sum,int i)
    {
        if(sum==0){return 1;}
        if(i<0){return 0;}
        if(dp[i][sum]!=-1){return dp[i][sum];}
        if(coins[i]<=sum)
        {
            return dp[i][sum]= helper(coins,sum-coins[i],i)+helper(coins,sum,i-1);
        }
        return dp[i][sum]=helper(coins,sum,i-1);
    }
    public int count(int coins[], int sum) {
        // code here.
        dp=new int[coins.length+1][sum+1];
        for(int i=0;i<coins.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(coins,sum,coins.length-1);
        
    }
}