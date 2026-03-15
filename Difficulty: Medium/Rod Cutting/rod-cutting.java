class Solution {
    int dp[][];
    public int helper(int[]price, int n, int c)
    {
        if(c==0||n==0){return 0;}
        if(dp[n][c]!=-1){return dp[n][c];}
        if(n<=c)
        {
            return dp[n][c]=Math.max(price[n-1]+helper(price,n,c-n),helper(price,n-1,c));
        }
        return dp[n][c]=helper(price,n-1,c);
    }
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        dp=new int[n+1][n+1];
        for(int i=0;i<n+1;++i){Arrays.fill(dp[i],-1);}
        return helper(price,n,n);
    }
}