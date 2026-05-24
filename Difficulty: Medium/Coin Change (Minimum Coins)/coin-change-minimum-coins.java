class Solution {

int dp[][];
public int helper(int coins[],int sum, int i)
{
    if(sum==0){return 0;}
    if(i<0){return 100000;}
    if(dp[i][sum]!=-1){return dp[i][sum];}
    if(coins[i]<=sum)
    {
        return dp[i][sum]=Math.min(helper(coins,sum,i-1),helper(coins,sum-coins[i],i)+1);
    }
    return dp[i][sum]=helper(coins,sum,i-1);
}
    public int minCoins(int coins[], int sum) {
        // code here
        dp=new int[coins.length+1][sum+1];
        for(int i=0;i<coins.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        int result=helper(coins, sum, coins.length-1);
        return result>=100000?-1:result;
    }
}