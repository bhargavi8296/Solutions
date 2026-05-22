class Solution {
    public void helper(char[][]grid, int i, int j)
    {
        int r[]={0,1,0,-1,1,-1,1,-1};
        int c[]={1,0,-1,0,1,-1,-1,1};
        for(int k=0;k<8;++k)
        {
            int tr=r[k]+i;
            int tc=c[k]+j;
            if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid[0].length&&grid[tr][tc]=='L')
            {
                grid[tr][tc]='W';
                helper(grid,tr,tc);
            }
        }
        
    }
    public int countIslands(char[][] grid) {
        // Code here
        int count=0;
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[0].length;++j)
            {
                if(grid[i][j]=='L')
                {
                    ++count;
                    grid[i][j]='W';
                    helper(grid,i,j);
                }
            }
        }
        return count;
    }
}