class Solution {
    int par[];
    int rank[];
    public int find(int u)
    {
        if(u==par[u]){return u;}
        return u=find(par[u]);
    }
    public void union(int x, int y,int px, int py)
    {
        if(rank[x]>rank[y])
        {
            par[py]=px;
            rank[px]+=rank[py];
        }
        else{
            par[px]=py;
            rank[py]+=rank[px];
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        par=new int[V];
        rank=new int[V];
        Arrays.fill(rank,1);
        for(int i=0;i<V;++i)
        {
            par[i]=i;
        }
        Queue<int[]>q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            int d=edges[i][2];
            q.add(new int[]{f,s,d});
        }
        int res=0;
        while(!q.isEmpty())
        {
            int []p=q.poll();
            int f=p[0];
            int s=p[1];
            int d=p[2];
            int px=find(f);
            int py=find(s);
            if(px!=py)
            {
                res+=d;
                union(f,s,px,py);
            }
        }
        return res;
    }
}
