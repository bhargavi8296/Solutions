class Solution {
    int rl;
    int cl;
    public void helper(int[][]grid, int r,int c)
    {
        grid[r][c]=0;
        int rm[]={0,1,0,-1};
        int cm[]={1,0,-1,0};
        for(int i=0;i<4;++i)
        {
            int tr=r+rm[i];
            int tc=c+cm[i];
            if(tr>=0&&tc>=0&&tr<rl&&tc<cl&&grid[tr][tc]==1)
            {
                helper(grid,tr,tc);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        int count=0;
        for(int i=0;i<rl;++i)
        {
            if(grid[i][0]==1){helper(grid,i,0);}
            if(grid[i][cl-1]==1){helper(grid,i,cl-1);}
        }
        for(int i=0;i<cl;++i)
        {
            if(grid[0][i]==1){helper(grid,0,i);}
            if(grid[rl-1][i]==1){helper(grid,rl-1,i);}
        }
        for(int i=0;i<rl;++i)
        {
            for(int j=0;j<cl;++j)
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