class Solution {
    int dist[][];
    public void helper(int [][]mat,int r,int c)
    {
        int ro[]={0,1,0,-1};
        int co[]={1,0,-1,0};
        for(int i=0;i<4;++i)
        {
            int tr=r+ro[i];
            int tc=c+co[i];
            if(tr>=0&&tr<mat.length&&tc>=0&&tc<mat[0].length&&mat[tr][tc]==1&&dist[tr][tc]>dist[r][c]+1)
            {
                dist[tr][tc]=dist[r][c]+1;
                helper(mat,tr,tc);
            }
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        dist=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;++i)
        {
            Arrays.fill(dist[i],100000);
        }
        for(int i=0;i<mat.length;++i)
        {
            for(int j=0;j<mat[i].length;++j)
            {
                if(mat[i][j]==0)
                {
                    dist[i][j]=0;
                    helper(mat,i,j);
                }
            }
        }
        // for(int i=0;i<mat.length;++i)
        // {
        //     for(int j=0;j<mat[i].length;++j)
        //     {
        //         if(dist[i][j]>10001)
        //         {
        //             dist[i][j]=0;
        //             helper(mat,i,j);
        //         }
        //     }
        // }
        return dist;
    }
}