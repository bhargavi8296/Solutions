class pair{
    int node;
    int dist;
    pair(int node, int dist)
    {
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    int dist[];
    ArrayList<ArrayList<pair>>list;
    public int networkDelayTime(int[][] times, int n, int k) {
        dist=new int[n+1];
        list=new ArrayList<>();
        for(int i=0;i<=n;++i)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;++i)
        {
            int f=times[i][0];
            int s=times[i][1];
            int d=times[i][2];
            list.get(f).add(new pair(s,d));
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        Queue<pair>q=new PriorityQueue<>((a,b)->a.dist-b.dist);
        q.add(new pair(k,0));
        while(!q.isEmpty())
        {
            pair temp=q.poll();
            int node=temp.node;
            int dis=temp.dist;
            for(pair p:list.get(node))
            {
                if(dist[p.node]>dis+p.dist)
                {
                    dist[p.node]=dis+p.dist;
                    q.add(new pair(p.node,dist[p.node]));
                }
            }
        }
        int res=-1;
        for(int i=1;i<=n;++i)
        {
            if(dist[i]==Integer.MAX_VALUE){return -1;}
            else{
                res=Math.max(res,dist[i]);
            }
        }
        return res;
    }
}