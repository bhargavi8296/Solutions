class Solution {
    int dp[][];
    public int helper(int mat[][],int row, int selected)
    {
        if(row==mat.length){return 0;}
        if(selected!=-1&&dp[row][selected]!=-1)
        {
            return dp[row][selected];
        }
        int ans=0;
        for(int i=0;i<3;++i)
        {
            if(i!=selected)
            {
                ans=Math.max(ans,mat[row][i]+helper(mat,row+1,i));
            }
        }
        if(selected!=-1)
        {dp[row][selected]=ans;}
        return ans;
    }
    public int maximumPoints(int mat[][]) {
        // code here
        dp=new int[mat.length][3];
        for(int i=0;i<mat.length;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(mat,0,-1);
        
    }
}