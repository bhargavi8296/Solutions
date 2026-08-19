class pair{
    int node;
    int dist;
    int k;
    pair(int node, int dist, int k)
    {
        this.node=node;
        this.dist=dist;
        this.k=k;
    }
}
class Pair{
    int node;
    int dist;
    Pair(int node, int dist)
    {
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ds[]=new int[n];
        List<List<Pair>>list=new ArrayList<>();
        for(int i=0;i<n;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;++i)
        {
            int f=flights[i][0];
            int s=flights[i][1];
            int d=flights[i][2];
            list.get(f).add(new Pair(s,d));
        }
        Arrays.fill(ds, Integer.MAX_VALUE);
        ds[src]=0;
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(src,0,k));
        while(!q.isEmpty())
        {
            pair temp=q.poll();
            int node=temp.node;
            int dis=temp.dist;
            int K=temp.k;
            if(K<0){continue;}
            for(Pair t:list.get(node))
            {
                if(ds[t.node]>dis+t.dist)
                {
                    ds[t.node]=dis+t.dist;
                    q.add(new pair(t.node,ds[t.node],K-1));
                }
            }
        }
        return ds[dst]==Integer.MAX_VALUE?-1:ds[dst];
    }
}