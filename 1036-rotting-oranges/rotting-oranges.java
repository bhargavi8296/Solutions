class Solution {
    int result[][];
    public void helper(int row,int col,int [][]grid)
    {
        int r[]={0,1,-1,0};
        int c[]={1,0,0,-1};
        for(int i=0;i<4;++i)
        {
            int tr=row+r[i];
            int tc=col+c[i];
            
            if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid[row].length&&grid[tr][tc]==1&&result[tr][tc]>result[row][col]+1)
            {
                result[tr][tc]=result[row][col]+1;
                helper(tr,tc,grid);
            }
        }
    }
    public int orangesRotting(int[][] grid) {
        result=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;++i)
        {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        } 
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[i].length;++j)
            {
                if(grid[i][j]==2)
                {
                    result[i][j]=0;
                    helper(i,j,grid);
                }
            }
        }
        int res=0;
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[i].length;++j)
            {
                if(grid[i][j]==1 && result[i][j]==Integer.MAX_VALUE){return -1;}
                else if(grid[i][j]==1){res=Math.max(res,result[i][j]);}
            }
        }
        return res;
    }
}