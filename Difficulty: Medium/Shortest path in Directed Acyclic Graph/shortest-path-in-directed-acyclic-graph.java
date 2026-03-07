// User function Template for Java
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

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        int dist[]=new int[V];
        Arrays.fill(dist,-1);
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<V;++i){list.add(new ArrayList<>());}
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];
            int s=edges[i][1];
            int d=edges[i][2];
            list.get(f).add(new pair(s,d));
        }
        Queue<pair>q=new PriorityQueue<>((a,b)->a.d-b.d);
        dist[0]=0;
        q.add(new pair(0,0));
        while(!q.isEmpty())
        {
            pair p=q.poll();
            int n=p.n;
            int d=p.d;
            for(pair node:list.get(n))
            {
                int val=node.n;
                int di=node.d;
                //System.out.println(n+" "+val+" "+(di+d));
                if(dist[val]==-1||dist[val]>di+d)
                {
                    dist[val]=di+d;
                    q.add(new pair(val,dist[val]));
                }
            }
        }
        return dist;
    }
}