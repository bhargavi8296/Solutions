class Solution {
    int dp[][];
    public int helper(int r, int c, int[][]mat)
    {
        if(r==mat.length||c==mat[0].length||mat[r][c]==1){return 0;}
        if(r==mat.length-1&&c==mat[0].length-1){return 1;}
        if(dp[r][c]!=-1){return dp[r][c];}
        return dp[r][c]=helper(r+1,c,mat)+helper(r,c+1,mat);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;++i)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,obstacleGrid);
    }
}