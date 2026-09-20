class Solution {
    public void helper(int[][]grid, int r, int c)
    {
        int ro[]={0,1,0,-1};
        int co[]={1,0,-1,0};
        for(int i=0;i<4;++i)
        {
            int tr=r+ro[i];
            int tc=c+co[i];
            if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid[0].length&&grid[tr][tc]==1)
            {
                grid[tr][tc]=0;
                helper(grid,tr,tc);
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid.length;++i)
        {
            //System.out.println(grid[i][0]+" "+i+" ");
            if(grid[i][0]==1){grid[i][0]=0;helper(grid,i,0);}
            if(grid[i][grid[0].length-1]==1){grid[i][grid[0].length-1]=0;helper(grid,i,grid[0].length-1);}
        }
        for(int i=0;i<grid[0].length;++i)
        {
            if(grid[0][i]==1){grid[0][i]=0;helper(grid,0,i);}
            if(grid[grid.length-1][i]==1){grid[grid.length-1][i]=0;helper(grid,grid.length-1,i);}
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