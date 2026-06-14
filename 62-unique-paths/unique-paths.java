class Solution {
    int dp[][];
    public int helper(int r, int c)
    {
        if(r==dp.length-1&&c==dp[0].length-1){return 1;}
        if(r==dp.length||c==dp[0].length){return 0;}
        if(dp[r][c]!=-1){return dp[r][c];}
        return dp[r][c]=helper(r+1,c)+helper(r,c+1);
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int i=0;i<m;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0);
    }
}