class pair{
    int n;
    int d;
    pair(int n, int d)
    {
        this.n=n;
        this.d=d;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        int []dist=new int[V];
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<V;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            int d=edges[i][2];
            list.get(f).add(new pair(s,d));
            list.get(s).add(new pair(f,d));
        }
        Queue<pair>q=new PriorityQueue<>((a,b)->a.d-b.d);
        q.add(new pair(src,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int node=p.n;
            int d=p.d;
            for(pair temp:list.get(node))
            {
                if(d+temp.d<dist[temp.n])
                {
                    dist[temp.n]=d+temp.d;
                    q.add(new pair(temp.n,dist[temp.n]));
                }
            }
        }
        return dist;
    }
}