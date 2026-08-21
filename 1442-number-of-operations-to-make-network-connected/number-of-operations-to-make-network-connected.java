class Solution {
    int par[];
    int range[];
    int count[];
    public int find(int x)
    {
        if(x==par[x]){return x;}
        return par[x]=find(par[x]);
    }
    public void union(int x, int y)
    {
        if(range[x]>range[y])
        {
            range[x]+=range[y];
            par[y]=x;
            count[x]+=1;
            count[x]+=count[y];
        }
        else{
            range[y]+=range[x];
            par[x]=y;
            count[y]+=1;
            count[y]+=count[x];
        }
    }
    public int makeConnected(int n, int[][] connections) {
        par=new int[n];
        range=new int[n];
        count=new int[n];
        for(int i=0;i<n;++i)
        {
            par[i]=i;
        }
        Arrays.fill(range,1);
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
            else{
                count[px]++;
            }
        }
        int c=0;
        int t=0;
        for(int i=0;i<n;++i)
        {
            if(par[i]==i)
            {
                ++c;
                t+=(count[i]-(range[i]-1));
            }
        }
        return t>=c-1?c-1:-1;
    }
}