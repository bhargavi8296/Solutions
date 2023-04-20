class Solution {
    int dp[][];
    public int dfs(int row,int col,int grid[][])
    {
        if(row==grid.length)
        {
            return col;
        }
        if(dp[row][col]!=-2)
        {
            return dp[row][col];
        }
        if(grid[row][col]==1)
        {
            if(col+1<grid[0].length&&grid[row][col+1]==1)
            {
                return dp[row][col]=dfs(row+1,col+1,grid);
            }
        }
        else
        {
            if(col-1>=0&&grid[row][col-1]==-1)
            {
                return dp[row][col]=dfs(row+1,col-1,grid);
            }
        }
        return -1;
    }
    public int[] findBall(int[][] grid) {
        dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;++i)
        {
            Arrays.fill(dp[i],-2);
        }
        for(int i=0;i<grid[0].length;++i)
        {
            dfs(0,i,grid);
        }
        for(int i=0;i<dp[0].length;++i)
        {
            if(dp[0][i]==-2)
            {
                dp[0][i]=-1;
            }
        }
        return dp[0];
    }
}