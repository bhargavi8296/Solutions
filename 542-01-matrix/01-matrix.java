class pair{
    int r;
    int c;
    pair(int r,int c)
    {
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int res[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;++i){Arrays.fill(res[i],Integer.MAX_VALUE);}
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<mat.length;++i)
        {
            for(int j=0;j<mat[i].length;++j)
            {
                if(mat[i][j]==0)
                {
                    q.add(new pair(i,j));
                    res[i][j]=0;
                    
                }
            }
        }
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int r=p.r;int c=p.c;
            int ro[]={1,0,-1,0};
            int co[]={0,1,0,-1};
            for(int i=0;i<4;++i)
            {
                int tr=r+ro[i];int tc=c+co[i];
                if(tr>=0&&tr<mat.length&&tc>=0&&tc<mat[0].length&&mat[tr][tc]==1&&res[tr][tc]>res[r][c]+1)
                {
                    res[tr][tc]=res[r][c]+1;
                    q.add(new pair(tr,tc));
                }
            }
        }
        return res;
    }
}