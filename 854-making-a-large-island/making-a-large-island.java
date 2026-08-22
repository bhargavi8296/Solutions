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
    int par[];
    int range[];
    public int find(int x)
    {
        if(x==par[x]){return x;}
        return par[x]=find(par[x]);
    }
    public void union(int x,int y)
    {
        if(range[x]>range[y])
        {
            range[x]+=range[y];
            par[y]=par[x];
        }
        else{
            range[y]+=range[x];
            par[x]=par[y];
        }
    }
    public int largestIsland(int[][] grid) {
        par=new int[grid.length*grid.length];
        range=new int[grid.length*grid.length];
        Arrays.fill(range,1);
        for(int i=0;i<grid.length*grid.length;++i)
        {
            par[i]=i;
        }
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[i].length;++j)
            {
                if(grid[i][j]==1)
                {
                    grid[i][j]=2;
                    Queue<pair>q=new LinkedList<>();
                    q.add(new pair(i,j));
                    while(!q.isEmpty())
                    {
                        pair p=q.poll();
                        int r=p.r;
                        int c=p.c;
                        int t1=r*grid.length+c;
                        int ro[]={0,1,0,-1};
                        int co[]={1,0,-1,0};
                        for(int k=0;k<4;++k)
                        {
                            int tr=r+ro[k];
                            int tc=c+co[k];
                            if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid.length&&grid[tr][tc]==1)
                            {
                                grid[tr][tc]=2;
                                int t2=tr*grid.length+tc;
                                int px=find(t1);
                                int py=find(t2);
                                if(px!=py){
                                    union(px,py);
                                    q.add(new pair(tr,tc));
                                }
                            }
                        }
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid.length;++j)
            {
                if(grid[i][j]==0)
                {
                    int ro[]={0,1,0,-1};
                    int co[]={1,0,-1,0};
                    List<Integer>list=new ArrayList<>();
                    int sum=0;
                    for(int k=0;k<4;++k)
                    {
                        int tr=i+ro[k];
                        int tc=j+co[k];
                        if(tr>=0&&tr<grid.length&&tc>=0&&tc<grid.length&&grid[tr][tc]==2&&!list.contains(find(tr*grid.length+tc)))
                        {
                            sum+=range[find(tr*grid.length+tc)];
                            list.add(find(tr*grid.length+tc));
                        }
                    }
                    max=Math.max(max,sum+1);
                }
                else if(par[i*grid.length+j]==(i*grid.length+j)){
                    max=Math.max(max,range[i*grid.length+j]);
                }
            }
        }
        return max;
    }
}
