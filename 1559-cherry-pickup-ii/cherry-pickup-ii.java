class Solution {
    int dp[][][];
    public int helper(int[][]grid, int r1,int c1, int c2)
    {
        if(r1>=grid.length||c1<0||c2<0||c1>=grid[0].length||c2>=grid[0].length)
        {
            return 0;
        }
        if(dp[r1][c1][c2]!=-1){return dp[r1][c1][c2];}
        int max=helper(grid,r1+1,c1+1,c2+1);
        max=Math.max(max,helper(grid,r1+1,c1+1,c2-1));
        max=Math.max(max,helper(grid,r1+1,c1+1,c2));
        max=Math.max(max,helper(grid,r1+1,c1-1,c2+1));
        max=Math.max(max,helper(grid,r1+1,c1-1,c2-1));
        max=Math.max(max,helper(grid,r1+1,c1-1,c2));
        max=Math.max(max,helper(grid,r1+1,c1,c2+1));
        max=Math.max(max,helper(grid,r1+1,c1,c2-1));
        max=Math.max(max,helper(grid,r1+1,c1,c2));
        if(c1==c2)
        {
            
            return dp[r1][c1][c2]=grid[r1][c1]+max;
        }
        return dp[r1][c1][c2]=grid[r1][c1]+grid[r1][c2]+max;
    }
    public int cherryPickup(int[][] grid) {
        dp=new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[0].length;++j)
             {Arrays.fill(dp[i][j],-1);}
        }
        return helper(grid,0,0,grid[0].length-1);
    }
}