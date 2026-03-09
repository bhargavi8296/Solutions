class Solution {
    int par[];
    int rank[];
    public int find(int x)
    {
        if(x==par[x]){return x;}
        return par[x]=find(par[x]);
    }
    public void union(int px, int py)
    {
        if(rank[px]>rank[py])
        {
            par[py]=px;
            rank[px]+=rank[py];
        }
        else
        {
            par[px]=py;
            rank[py]+=rank[px];
        }
    }
    public int makeConnected(int n, int[][] connections) {
        par=new int[n];rank=new int[n];
        Arrays.fill(rank,1);
        for(int i=0;i<n;++i){par[i]=i;}
        int count=0;
        for(int i=0;i<connections.length;++i)
        {
            int x=connections[i][0];
            int y=connections[i][1];
            int px=find(x);
            int py=find(y);
            if(px!=py)
            {
                union(px,py);
            }
            else{++count;}
        }
        int c=0;
        for(int i=0;i<n;++i)
        {
            if(par[i]==i){++c;}
        }
        //System.out.print(count+" "+c);
        return count>=(c-1)?c-1:-1;
    }
}