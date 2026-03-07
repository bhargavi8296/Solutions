class pair{
    int n;
    int d;
    pair(int n,int d)
    {
        this.n=n; this.d=d;
    }
}
class Solution {
    ArrayList<ArrayList<Integer>>list;
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        list=new ArrayList<>();
        for(int i=0;i<V;++i){list.add(new ArrayList<>());}
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            list.get(f).add(s);
            list.get(s).add(f);
        }
        Queue<pair>q=new PriorityQueue<>((a,b)->a.d-b.d);
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        q.add(new pair(src,0));
        dist[src]=0;
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int n=p.n;
            int d=p.d;
            for(int val:list.get(n))
            {
                if(dist[val]>dist[n]+1)
                {
                    dist[val]=dist[n]+1;
                    q.add(new pair(val,dist[val]));
                }
            }
        }
        for(int i=0;i<V;++i){if(dist[i]==Integer.MAX_VALUE){dist[i]=-1;}}
        return dist;
    }
}
