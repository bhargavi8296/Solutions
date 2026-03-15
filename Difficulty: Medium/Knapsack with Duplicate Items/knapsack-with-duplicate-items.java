class Solution {
    int dp[][];
    public int helper(int val[], int wt[], int c,int n)
    {
        
        if(c==0){return 0;}
        if(c<0||n<0){return 0;}
        //System.out.print(wt[n]+" "+c);
        if(dp[n][c]!=-1){return dp[n][c];}
        if(wt[n]<=c)
        {
            
            return dp[n][c]=Math.max(val[n]+helper(val,wt,c-wt[n],n),helper(val,wt,c,n-1));
        }
        return dp[n][c]=helper(val,wt,c,n-1);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        dp=new int[wt.length+1][capacity+1];
        for(int i=0;i<wt.length+1;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(val,wt,capacity,wt.length-1);
    }
}