class Solution {
    int range[];
    int par[];
    public int findpar(int x)
    {
        if(x==par[x]){return x;}
        return par[x]=findpar(par[x]);
    }
    public void union(int x, int y)
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
    public int findCircleNum(int[][] isConnected) {
        par=new int[isConnected.length];
        range=new int[isConnected.length];
        Arrays.fill(range,1);
        for(int i=0;i<isConnected.length;++i)
        {
            par[i]=i;
        }
        for(int i=0;i<isConnected.length;++i)
        {
            for(int j=0;j<isConnected.length;++j)
            {
                if(i!=j&&isConnected[i][j]==1)
                {
                    int px=findpar(i);
                    int py=findpar(j);
                    if(px!=py)
                    {
                        union(px,py);
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<isConnected.length;++i)
        {
            if(i==par[i]){++count;}
        }
        return count;
    }
}