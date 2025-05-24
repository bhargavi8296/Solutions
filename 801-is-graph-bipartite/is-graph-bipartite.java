class Solution {
    public boolean isBipartite(int[][] graph) {
        int []color=new int[graph.length];
        Arrays.fill(color,-1);
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<graph.length;++i)
        {
            if(color[i]==-1)
            {
                color[i]=0;
                q.add(i);
                while(!q.isEmpty())
                {
                    int node=q.remove();
                    for(int val:graph[node])
                    {
                        if(color[val]!=-1)
                        {
                            if(color[val]==color[node]){return false;}
                        }
                        else
                        {
                            color[val]=color[node]==0?1:0;
                            q.add(val);

                        }
                    }
                }
            }
        }
        return true;
    }
}