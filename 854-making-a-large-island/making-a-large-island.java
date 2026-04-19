class Solution {
    int par[];
    int size[];
    int gr;
    int gc;
    public void union(int px, int py)
    {
        if(size[px]>=size[py])
        {
            par[py]=px;
            size[px]+=size[py];
        }
        else
        {
            par[px]=py;
            size[py]+=size[px];
        }
    }
    public int find(int x)
    {
        if(x==par[x]){return x;}
        return par[x]=find(par[x]);
    }
    public void bfs(int r,int c, int[][]grid)
    {
        grid[r][c]=2;
        int ro[]={0,1,0,-1};
        int co[]={1,0,-1,0};
        int pr=r*gc+c;
        int gpr=find(pr);
        for(int i=0;i<4;++i)
        {
            int tr=r+ro[i];
            int tc=c+co[i];
            if(tr>=0&&tr<gr&&tc>=0&&tc<gc&&grid[tr][tc]==1)
            {
                int ch=tr*gc+tc;
                int gpc=find(ch);
                if(gpr!=gpc){union(gpr,gpc);}
                bfs(tr,tc,grid);
            }
        }
    }
    public int largestIsland(int[][] grid) {
        gr=grid.length;
        gc=grid[0].length;
        par=new int[gr*gc];
        size=new int[gr*gc];
        Arrays.fill(size,1);
        for(int i=0;i<gr*gc;++i){par[i]=i;}
        for(int i=0;i<gr;++i)
        {
            for(int j=0;j<gc;++j)
            {
                if(grid[i][j]==1)
                {
                    bfs(i,j,grid);
                }
            }
        }
        int globalres=0;
        int count=0;
        for(int i=0;i<gr;++i)
        {
            for(int j=0;j<gc;++j)
            {
                if(grid[i][j]==0)
                {
                    if(count==0){++count;}
                    int ro[]={0,1,0,-1};
                    int co[]={1,0,-1,0};
                    int result=0;
                    Set<Integer>s=new HashSet<>();
                    for(int k=0;k<4;++k)
                    {
                        int tr=i+ro[k];
                        int tc=j+co[k];
                        if(tr>=0&&tr<gr&&tc>=0&&tc<gc&&grid[tr][tc]==2)
                        {
                            int temp=find(tr*gc+tc);
                            if(!s.contains(temp))
                            {
                                result+=size[temp];
                                s.add(temp);
                            }
                        }

                    }
                    globalres=Math.max(result+1,globalres);
                }
            }
        }
        return count!=0?globalres:gr*gc;
    }
}