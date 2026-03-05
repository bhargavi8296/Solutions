class Solution {
    public void helper(int[][]grid,int r,int c)
    {
        if(grid[r][c]==0){return;}
        grid[r][c]=0;
        int ro[]={0,1,0,-1};
        int co[]={1,0,-1,0};
        for(int i=0;i<4;++i)
        {
            int tr=r+ro[i];
            int tc=c+co[i];
            if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid[0].length&&grid[tr][tc]==1)
            {
                helper(grid,tr,tc);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[i].length;++j)
            {
                if((i==0||j==0||i==grid.length-1||j==grid[0].length-1)&&grid[i][j]==1)
                {
                    helper(grid,i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[i].length;++j)
            {
                if(grid[i][j]==1)
                {
                    ++count;
                }
            }
        }
        return count;
    }
}