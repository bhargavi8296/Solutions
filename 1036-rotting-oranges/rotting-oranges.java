class pair{
    int r;
    int c;
    pair(int r, int c)
    {
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<pair>q=new LinkedList<>();
        int[][]mat=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;++i)
        {
            Arrays.fill(mat[i],Integer.MAX_VALUE);
            for(int j=0;j<grid[i].length;++j)
            {
                if(grid[i][j]==2)
                {
                    q.add(new pair(i,j));
                    mat[i][j]=0;
                }
            }
        }
        int res=0;
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int row[]={0,1,-1,0};
            int col[]={1,0,0,-1};
            for(int i=0;i<4;++i)
            {
                int tr=r+row[i];
                int tc=c+col[i];
                if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid[0].length&&grid[tr][tc]==1&&mat[tr][tc]>mat[r][c]+1)
                {
                    mat[tr][tc]=mat[r][c]+1;
                    grid[tr][tc]=2;
                    res=Math.max(res,mat[tr][tc]);
                    q.add(new pair(tr,tc));
                }
            }
        }
        for(int i=0;i<grid.length;++i)
        {
            Arrays.fill(mat[i],Integer.MAX_VALUE);
            for(int j=0;j<grid[i].length;++j)
            {
                if(grid[i][j]==1)
                {
                    return -1;
                }
            }
        }
        return res;
    }
}