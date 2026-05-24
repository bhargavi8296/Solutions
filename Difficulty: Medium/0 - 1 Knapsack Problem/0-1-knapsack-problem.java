class Solution {
    int dp[][];
    public int helper(int W, int val[],int wt[],int i)
    {
        if(i<0){return 0;}
        if(dp[i][W]!=-1){return dp[i][W];}
        if(wt[i]<=W)
        {
            return dp[i][W]=Math.max(helper(W-wt[i],val,wt,i-1)+val[i],helper(W,val,wt,i-1));
        }
        return dp[i][W]=helper(W,val,wt,i-1);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        dp=new int[wt.length+1][W+1];
        for(int i=0;i<wt.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(W,val,wt,wt.length-1);
    }
}
