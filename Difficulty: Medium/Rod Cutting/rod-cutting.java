class Solution {
    int dp[][];
    public int helper(int[]price, int i, int n)
    {
        if(n<=0||i<=0){return 0;}
        if(dp[i][n]!=-1){return dp[i][n];}
        if(i<=n)
        {
            return dp[i][n]=Math.max(helper(price,i,n-i)+price[i-1],helper(price,i-1,n));
        }
        return helper(price,i-1,n);
    }
    public int cutRod(int[] price) {
        // code here
        dp=new int[price.length+1][price.length+1];
        for(int i=0;i<price.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(price, price.length,price.length);
    }
}
// rod helper(price, int n int c)
// cut -> choose kar bhi skte hai or nahi bhi
// karenge price n-c c 