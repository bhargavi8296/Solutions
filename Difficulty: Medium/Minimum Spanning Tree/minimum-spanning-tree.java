class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<int[]>>list=new ArrayList<>();
        for(int i=0;i<V;++i){list.add(new ArrayList<>());}
        for(int i=0;i<edges.length;++i)
        {
            int f=edges[i][0];int s=edges[i][1]; int d=edges[i][2];
            list.get(f).add(new int[]{s,d});
            list.get(s).add(new int[]{f,d});
        }
        int vis[]=new int[V];
        Queue<int[]>q=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int res=0;
        for(int i=0;i<V;++i)
        {
            
            if(vis[i]==0)
            {
                q.add(new int[]{i,0});
                while(!q.isEmpty())
                {
                    int []p=q.poll();
                    int node=p[0];
                    int d=p[1];
                    if(vis[node]==0)
                    {
                        //System.out.println(node+" "+d);
                        vis[node]=1;
                        res+=d;
                    }
                    else{continue;}
                    for(int []t:list.get(node))
                    {
                        int f=t[0];
                        int dis=t[1];
                        if(vis[f]==0)
                        {
                            q.add(new int[]{f,dis});
                        }
                    }
                }
            }
        }
        return res;
        
    }
}
