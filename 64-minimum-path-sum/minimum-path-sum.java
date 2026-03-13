class Solution {
    public int minPathSum(int[][] grid) {
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[i].length;++j)
            {
                if(i==0||j==0)
                {
                    grid[i][j]+=(i==0?j-1>=0?grid[i][j-1]:0:grid[i-1][j]);
                }
                else{
                    grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}