class Solution {
    int dp[][][];
    public int helper(int[][]grid, int i, int j1, int j2)
    {
        if(j1<0||j1>=grid[0].length||j2<0||j2>=grid[0].length){return Integer.MIN_VALUE;}
        if(i==grid.length-1)
        {
            if(j1==j2){return grid[i][j1];}
            return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1){return dp[i][j1][j2];}
        int max=Integer.MIN_VALUE;
        for(int j=-1;j<=1;++j)
        {
            for(int k=-1;k<=1;++k)
            {
                if(j1==j2){
                    max=Math.max(max,grid[i][j1]+helper(grid,i+1,j1+j,j2+k));
                }
                else{
                    max=Math.max(max,grid[i][j1]+grid[i][j2]+helper(grid,i+1,j1+j,j2+k));
                }
            }
        }
        return dp[i][j1][j2]=max;
    }
    public int cherryPickup(int[][] grid) {
        dp=new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[i].length;++j)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(grid,0,0,grid[0].length-1);
    }
}